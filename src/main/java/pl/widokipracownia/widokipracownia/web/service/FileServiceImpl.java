package pl.widokipracownia.widokipracownia.web.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.File;
import pl.widokipracownia.widokipracownia.repository.FileRepository;

import java.io.IOException;


@Service
@RequiredArgsConstructor
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;

    public File save(MultipartFile multipartFile) {
        byte[] data = null;
        try {
            data = multipartFile.getBytes();
        } catch (IOException e) {
            e.printStackTrace();
        }
        File file = new File(multipartFile.getOriginalFilename(), multipartFile.getContentType(), data);
        return fileRepository.save(file);
    }


}
