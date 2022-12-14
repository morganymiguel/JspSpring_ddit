package kr.or.ddit.vo;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import javax.servlet.http.Part;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.fileupload.FileItem;

import com.fasterxml.jackson.annotation.JsonIgnore;

import kr.or.ddit.file.MultipartFile;
import kr.or.ddit.validate.InsertGroup;
import kr.or.ddit.validate.UpdateGroup;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString(exclude = {"prodDetail"})
@EqualsAndHashCode(of = {"prodId"})
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdVO implements Serializable{
	
	private int rnum;
	@NotBlank(groups = {UpdateGroup.class})
	private String prodId;
	@NotBlank(groups = {InsertGroup.class})
	private String prodName;
	@NotBlank(groups = {InsertGroup.class})
	private String prodLgu;
	
	private String lprodNm;
	@NotBlank(groups = {InsertGroup.class})
	private String prodBuyer;
	@NotNull
	@Min(0)
	private Integer prodCost;
	@NotNull
	@Min(0)
	private Integer prodPrice;
	@NotNull
	@Min(0)
	private Integer prodSale;
	@NotBlank
	@Size(max = 50)
	private String prodOutline;
	@JsonIgnore
	private transient String prodDetail;
	@NotBlank
	private String prodImg;
	
	private MultipartFile prodImage;
	
	public void setProdImage(MultipartFile prodImage) {
		if(prodImage!=null && !prodImage.isEmpty()) {
			this.prodImage = prodImage;
			this.prodImg = UUID.randomUUID().toString();
		}
	}
	
	public void saveTo(File saveFolder) throws IOException {
		if(prodImage==null) return;
		File saveFile = new File(saveFolder, this.prodImg);
		prodImage.transferTo(saveFile);
	}
	
	@NotNull
	@Min(0)
	private Integer prodTotalstock;
	private String prodInsdate;
	@NotNull
	@Min(0)
	private Integer prodProperstock;
	private String prodSize;
	private String prodColor;
	private String prodDelivery;
	@Size(max = 3)
	private String prodUnit;
	private Integer prodQtyin;
	private Integer prodQtysale;
	private Integer prodMileage;
	
	private BuyerVO buyer; // has A
	
	private Set<MemberVO> memberList; // has Many
	
	private Integer memCount;
}











