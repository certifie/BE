package ua.andrew.certifie.model;


import com.fasterxml.jackson.annotation.JsonProperty;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "certificates")
@EntityListeners(AuditingEntityListener.class)
public class Certificate implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    @Column(unique = true)
    private String id;

    @NotBlank
    private String title;

    @NotBlank
    private String issuer;

    @NotBlank
    private String issueDate;

    @NotNull
    private String expiryDate;

    @NotBlank
    private String serialNumber;

    @JsonProperty
    private boolean expiry;

    @NotBlank
    private String description;

    @NotBlank
    private String courseUrl;

    //    TODO write class which will handle certificate attachment
    //    private Attachment attachment;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getIssuer() {
        return issuer;
    }
    public void setIssuer(String issuer) {
        this.issuer = issuer;
    }
    public String getSerialNumber() {
        return serialNumber;
    }
    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getCourseUrl() {
        return courseUrl;
    }
    public void setCourseUrl(String courseUrl) {
        this.courseUrl = courseUrl;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getIssueDate() {
        return issueDate;
    }
    public void setIssueDate(String issueDate) {
        this.issueDate = issueDate;
    }
    public String getExpiryDate() {
        return expiryDate;
    }
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public boolean getExpiry() {
        return expiry;
    }
    public void setExpiry(boolean expiry) {
        this.expiry = expiry;
    }
}
