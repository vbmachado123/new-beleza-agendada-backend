package br.com.vbdev.beleza_agendada.model;

import br.com.vbdev.beleza_agendada.model.types.PaymentMethod;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "payment_method")
public class PaymentMethodModel implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    public PaymentMethodModel() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentMethodModel)) return false;
        PaymentMethodModel that = (PaymentMethodModel) o;
        return id.equals(that.id) && paymentMethod == that.paymentMethod;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, paymentMethod);
    }
}
