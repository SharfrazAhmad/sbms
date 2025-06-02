package in.nit.binding;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductInfo {
    
    private Integer pId;
    private String pName;
    private String mfgDate;
    private String expDate;
    private Double price;
}
