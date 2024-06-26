package Lab.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tbl_todo")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Todo extends AbstractModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "todo", nullable = false)
    private String todo;

    @Column(name = "priority", nullable = false)
    private int priority;
}
