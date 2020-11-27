package in.jobcounsel.services.core.search;

import java.util.List;
import java.util.Map;

public interface DataSearchOperations {

	public boolean addDataToIndex(List<Map<String, String>> datas);

	public boolean removeDataInIndex(Map<String, String> data);

	public List<Long> searchDataInIndex(String query,int sector);

	public boolean resetDataInIndex();

}
