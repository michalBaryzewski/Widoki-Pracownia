package pl.widokipracownia.widokipracownia.web.service;

import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import pl.widokipracownia.widokipracownia.entity.File;
import pl.widokipracownia.widokipracownia.repository.FileRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@Service
public class FileServiceImpl implements FileService {

    private final FileRepository fileRepository;
    private final HttpHeaders httpHeaders;

    public FileServiceImpl(FileRepository fileRepository) {
        this.fileRepository = fileRepository;
        this.httpHeaders = new org.springframework.http.HttpHeaders();
        this.httpHeaders.setContentType(MediaType.MULTIPART_FORM_DATA);
    }


    public File save(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename(), multipartFile.getContentType(), multipartFile.getBytes());
        return fileRepository.save(file);
    }


}
