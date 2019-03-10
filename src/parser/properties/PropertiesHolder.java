package parser.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class PropertiesHolder {

    @Value("${newCompany}")
    private String FileFirma;
    @Value("${authorizations}")
    private String fileUprawnienia;
    @Value("${branches}")
    private String fileOddzialy;
    @Value("${noAddress}")
    private String fileNoAddress;
    @Value("${codeTeryt}")
    private String fileTeryt;

    public PropertiesHolder() {
    }

    public String getFileFirma() {
        return FileFirma;
    }

    public String getFileUprawnienia() {
        return fileUprawnienia;
    }

    public String getFileOddzialy() {
        return fileOddzialy;
    }

    public String getFileNoAddress() {
        return fileNoAddress;
    }

    public String getFileTeryt() {
        return fileTeryt;
    }
}
