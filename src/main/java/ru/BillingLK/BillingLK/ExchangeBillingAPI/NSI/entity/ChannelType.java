package ru.BillingLK.BillingLK.ExchangeBillingAPI.NSI.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class ChannelType {

    @Id
    //@GeneratedValue(generator = "uuid2")
    //@GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    private boolean isDelete;

    @Column(updatable = true, nullable = false, length = 50)
    private String name;

    @OneToMany(mappedBy = "channelType", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Scale> scales = new ArrayList<>();
}
