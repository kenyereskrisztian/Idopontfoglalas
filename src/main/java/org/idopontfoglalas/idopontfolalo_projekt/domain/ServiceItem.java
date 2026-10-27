package org.idopontfoglalas.idopontfolalo_projekt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@Table(name = "services")
@NoArgsConstructor
@AllArgsConstructor
public class ServiceItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Long duration;
    private Long price;

    @OneToMany(mappedBy = "serviceItem", fetch = FetchType.LAZY)
    private List<Reservation> reservations;
}