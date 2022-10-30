package com.observationclass.entity;

import com.observationclass.ultis.Utils;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Common {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @NotFound(action = NotFoundAction.IGNORE)
    private Integer id;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP default NOW()")
    private Timestamp createdAt = Utils.resultTimestamp();

    @Column(name = "updated_at", nullable = false, columnDefinition = "TIMESTAMP default NOW()")
    private Timestamp updatedAt = Utils.resultTimestamp();


    @Column(name = "delete_flag", columnDefinition = "integer DEFAULT 0")
    private Integer deleteFlag = 0;

    public void setRegist(){
        this.createdAt=Utils.resultTimestamp();
        this.deleteFlag=0;
    }
    public void setUpdate() {
        this.updatedAt=Utils.resultTimestamp();
        this.deleteFlag=0;
    }


}
