package store.model;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "baskets")
public class Basket {
    @Id
    private Long id;
    @OneToMany
    @JoinTable(name = "baskets_chosen",
            joinColumns = @JoinColumn(name = "basket_id"),
            inverseJoinColumns = @JoinColumn(name = "chosen_id"))
    private List<Chosen> chosen;
    @MapsId
    @OneToOne
    @JoinColumn(name = "id")
    private User user;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Chosen> getChosen() {
        return chosen;
    }

    public void setChosen(List<Chosen> chosen) {
        this.chosen = chosen;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Basket{" + "id=" + id
                + ", chosen=" + chosen
                + ", user=" + user
                + '}';
    }
}
