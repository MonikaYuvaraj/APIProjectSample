package mapWrite;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor


public class LF1RootPojoWrite {



	private int page;
	private int per_page;
	private int total;
	private int total_pages;
	private ArrayList<DatumWrite> data;
	private LF1SupportWrite support;

	

}
