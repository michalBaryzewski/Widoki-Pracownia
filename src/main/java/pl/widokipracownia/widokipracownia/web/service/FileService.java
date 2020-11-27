package pl.widokipracownia.widokipracownia.web.service;

import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.File;

import java.io.IOException;

public interface FileService {

    public File save(MultipartFile multipartFile) throws IOException;

}
