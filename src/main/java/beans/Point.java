package beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@Data
@ManagedBean
@SessionScoped
@NoArgsConstructor
@AllArgsConstructor
public class Point {
    private double xVal;
    private double yVal;
    private double rVal = 1.0;
    private long timezone;
}


//FetchType.EAGER
//каскад хибернейт связывание таблиц
//проблема n+1