package pl.widokipracownia.widokipracownia.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FileWrapper {

    private String name;
    private String type;
    private byte[] data;

    public static FileWrapper wrapper(MultipartFile file) {
        FileWrapper fileWrapper = new FileWrapper();
        try {
            fileWrapper.setData(file.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
        fileWrapper.setName(file.getOriginalFilename());
        fileWrapper.setType(file.getContentType());
        return fileWrapper;
    }
}
