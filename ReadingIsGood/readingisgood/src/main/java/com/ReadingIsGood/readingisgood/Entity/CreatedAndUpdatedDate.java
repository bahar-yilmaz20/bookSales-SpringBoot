package com.ReadingIsGood.readingisgood.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.istack.NotNull;
import lombok.*;

import java.time.Instant;
import java.util.Date;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public abstract class CreatedAndUpdatedDate {
    @JsonFormat(pattern="yyyy-MM-dd")
    @NotNull
    public Date createdAt;
    @JsonFormat(pattern="yyyy-MM-dd")
    public Date updatedAt;
    public void setCreatedAt(){
        this.createdAt=Date.from(Instant.now());
    }

}
