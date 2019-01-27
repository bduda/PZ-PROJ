package test.payload;

import lombok.Data;
import org.hibernate.annotations.NaturalId;

import javax.validation.constraints.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class CodeSaveRequest {

    private String id;

    @NotBlank
    @Size(min = 6, max = 6)
    private String kind;

    @NaturalId
    @Size(min = 10, max=10)
    private String code;

    @NotBlank
    @Size(min = 1, max = 2)
    private String type;

    @NotBlank
    private String value;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public float getValue() {
        return Float.parseFloat(value);
    }

    public void setValue(String value) {
        this.value = value;
    }


}
