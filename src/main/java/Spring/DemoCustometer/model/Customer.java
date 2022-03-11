package Spring.DemoCustometer.model;
import org.hibernate.annotations.*;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.*;
import java.io.Serializable;

@Entity
@Table(name="customer")
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id=?")
@FilterDef(
        name = "deletedUserFilter",
        parameters = @ParamDef(name = "isDeleted", type = "boolean")
)
@Filter(
        name = "deletedUserFilter",
        condition = "deleted = :isDeleted"
)
@Where(clause = "deleted=false")
public class Customer implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "firstname")
    @NotNull(message = "firstName is mandatory")
    @NotBlank(message = "firstName is mandatory")
    private String firstName;

    @Column(name = "middleName")
    private String middleName;

    @Column(name = "lastname")
    @NotNull
    @NotBlank(message = "LastName is mandatory")
    private String lastName;

    @Column(name = "address")
    @NotNull
    @NotBlank(message = "Address is mandatory")
    private String address;

    @Column(name = "phoneNo")
    @NotNull
    @NotBlank(message = "Phone must not be blank")
    @Pattern(regexp = "(0|91)?[6789][0-9]{9}",message = "Invalid PhoneNo")
    private String phoneNo;

    @Column(name = "DOB",nullable = false)
    @NotBlank(message = "DOB must not be blank")
    private String  dob;

    @Column(name = "Email",nullable = false)
    @Email(message = "Email is invalid")
    @NotBlank
    @Pattern(regexp = "[A-Za-z0-9][A-Za-z0-9_.]*@[a-zA-Z0-9]+([.][a-zA-Z0-9]+)+",message = "Invalid Email")
    private String email;


    @Column(name = "Cus_Age")
    @Min(value = 18,message = "Age can not less than 18")
    @Max(value = 45,message = "Age can not more than 45")
    private String age;

    @Column(name = "gender",nullable = false)
    private Gender gender;

    @Column(name = "Deleted")
    private boolean deleted = Boolean.FALSE;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age =age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Customer() {
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
