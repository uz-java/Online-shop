package olcha.uz.onlineShop.services;

import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import olcha.uz.onlineShop.domains.Uploads;
import olcha.uz.onlineShop.exceptions.NotFoundException;
import olcha.uz.onlineShop.repository.FileStorageRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

/**
 * @author "Tojaliyev Asliddin"
 * @since 06/08/22 14:14 (Saturday)
 * SpringMyProject/IntelliJ IDEA
 */

@Service
@RequiredArgsConstructor
public class FileStorageService {
    private final Path rootPath=Path.of("/home/asliddin/IdeaProjects/Spring_my/SpringMyProject/src/main/resources/static/images");
    private final FileStorageRepository fileStorageRepository;



    @Transactional
    public Uploads upload(MultipartFile multipartFile) {
        try {
            String contentType = multipartFile.getOriginalFilename();
            String originalFilename = multipartFile.getOriginalFilename();
            long size = multipartFile.getSize();

            String filename = StringUtils.getFilename(originalFilename);
            String filenameExtension = StringUtils.getFilenameExtension(originalFilename);
            String generatedName = System.currentTimeMillis() + "." + filenameExtension;
            String path = "\\static\\images\\" + generatedName;
            Uploads uploads = Uploads.builder()
                    .contentType(contentType)
                    .originalName(filename)
                    .size(size)
                    .generatedName(generatedName)
                    .path(path)
                    .build();


            Path uploadPath = rootPath.resolve(generatedName);
            fileStorageRepository.save(uploads);
            Files.copy(multipartFile.getInputStream(), uploadPath, StandardCopyOption.REPLACE_EXISTING);
            return uploads;
        } catch (IOException e) {
            throw new RuntimeException("Something wrong try again");
        }
    }


    public ResponseEntity<Resource> download(@NonNull String filename){
        Path path=rootPath.resolve(filename);
        Resource resource=new FileSystemResource(path);
        Uploads uploads=fileStorageRepository.findByGeneratedName(filename).orElseThrow(() -> {
            throw new NotFoundException("File not found");
        });

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploads.getContentType()))
                .contentLength(uploads.getSize())
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename=\""+uploads.getOriginalName()+"\"").body(resource);
    }

    public List<Uploads> getAll(){
        return fileStorageRepository.findAll();
    }
}
