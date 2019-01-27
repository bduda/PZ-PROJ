package test.payload;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class IdTmpReq {

    @NotBlank
    public String id;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
