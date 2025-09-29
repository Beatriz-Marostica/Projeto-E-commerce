package br.edu.utfpr.pb.pw44s.server.error;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Map;

@Data
@NoArgsConstructor
public class ApiError {

    private final long timestamp = new Date().getTime();
    private String message;
    private int status;
    private String url;
    private Map<String, String> validationErros;

    public ApiError(String message, int status, String url) {
        this.message = message;
        this.status = status;
        this.url = url;
    }

    public ApiError(String message, int status, String url, Map<String, String> validationErros) {
        this.message = message;
        this.status = status;
        this.url = url;
        this.validationErros = validationErros;
    }

    public long getTimestamp() {
        return timestamp;
    }
    public String getMessage() {
        return message;
    }
    public int getStatus() {
        return status;
    }
    public String getUrl() {
        return url;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setStatus(int status) {
        this.status = status;
    }
    public void setUrl(String url) {
        this.url = url;
    }
}
