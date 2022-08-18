package br.com.api.product.dto.response;

import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

public class ResponseError {

    @NotNull(message = "Timestamp cannot be null")
    private LocalDateTime dateTime;

    @NotNull(message = "Details cannot be null")
    private String details;

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
