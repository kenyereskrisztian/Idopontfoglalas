package org.idopontfoglalas.idopontfolalo_projekt.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "reservation")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @ManyToOne
    @JoinColumn(name = "service_id", nullable = false)
    private ServiceItem serviceItem;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status;
    private String startTime;
    private String endTime;

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", account=" + account.getName() +
                ", service=" + serviceItem +
                ", status='" + status.toString() + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}