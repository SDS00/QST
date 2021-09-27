package sds.qst.entity;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@NoArgsConstructor
public class ExchangeRate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    @ManyToOne
    private Currency from;

    @NotNull
    @ManyToOne
    private Currency to;

    @NotNull
    @Column(nullable = false)
    private double value;

    @NotNull
    @Column(nullable = false)
    private Date date;

    public ExchangeRate(Currency from, Currency to, double value, Date date) {
        this.from = from;
        this.to = to;
        this.value = value;
        this.date = date;
    }
}
