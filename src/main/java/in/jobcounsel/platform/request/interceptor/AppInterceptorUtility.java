package in.jobcounsel.platform.request.interceptor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AppInterceptorUtility {

	private static Logger logger = LoggerFactory.getLogger(AppInterceptorUtility.class);

	protected static boolean writeIPAddressToFile(String fileName, Map<String, Integer> ipAddresses) {
		boolean result = true;
		try {
			writeIPAddToFile(fileName, ipAddresses);
		} catch (Exception e) {
			result = false;
		}
		return result;
	}

	private static boolean writeIPAddToFile(String fileName, Map<String, Integer> ipAddresses) throws IOException {
		File file = new File(fileName);
		FileWriter fw = null;
		BufferedWriter bw = null;
		try {
			fw = new FileWriter(file, true);
			bw = new BufferedWriter(fw);
			Set<String> ipAddressAsKeys = ipAddresses.keySet();
			for (String ipAddress : ipAddressAsKeys) {
				Integer accessCount = ipAddresses.get(ipAddress);
				StringBuilder data = new StringBuilder();
				data.append(ipAddress);
				data.append(" : ");
				data.append(accessCount);
				bw.write(data.toString());
				bw.newLine();
			}
		} catch (IOException e) {
			logger.error("Error While Writing IP Address To File ");
			throw e;
		} finally {
			if (bw != null)
				bw.close();

			if (fw != null)
				fw.close();
		}
		return true;
	}
}
