package in.jobcounsel.services.core;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.google.common.net.UrlEscapers;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Element;

import in.jobcounsel.services.core.models.JobCoreModel;

@Service
public class JobPDFFileCreation {

	private static Logger logger = LoggerFactory.getLogger(JobPDFFileCreation.class);

	private static final String WEB_PAGE_URL = "https://jobcounsel.in";

	public static Boolean createJobPDFFile(String fileName, List<JobCoreModel> jobList) {
		
		Boolean pdfCreation = true;

		Font bfBold12 = new Font(FontFamily.TIMES_ROMAN, 12, Font.BOLD, new BaseColor(255, 255, 255));
		Font bf12 = new Font(FontFamily.TIMES_ROMAN, 12);

		Document document = new Document(PageSize.A4);

		document.addAuthor("JobCounsel India");
		document.addCreationDate();
		document.addProducer();
		document.addCreator("jobcounsel.in");
		document.addTitle("List Of Active Indian Government Jobs");
		document.setPageSize(PageSize.LETTER);

		try {
			OutputStream outputStream = new FileOutputStream(new File(fileName));

			PdfWriter writer = PdfWriter.getInstance(document, outputStream);

			document.open();

			float[] columnWidths = { 3.5f, 3f, 5f, 2f, 2.5f, 2f };

			PdfPTable pdfPTable = new PdfPTable(columnWidths);

			pdfPTable.setWidthPercentage(95f);

			insertCell(pdfPTable, "Organization", Element.ALIGN_CENTER, 1, bfBold12, true, null);
			insertCell(pdfPTable, "Designation", Element.ALIGN_CENTER, 1, bfBold12, true, null);
			insertCell(pdfPTable, "Qualification", Element.ALIGN_CENTER, 1, bfBold12, true, null);
			insertCell(pdfPTable, "Location", Element.ALIGN_CENTER, 1, bfBold12, true, null);
			insertCell(pdfPTable, "Last Date", Element.ALIGN_CENTER, 1, bfBold12, true, null);
			insertCell(pdfPTable, "Details", Element.ALIGN_CENTER, 1, bfBold12, true, null);

			insertCell(pdfPTable, "", Element.ALIGN_LEFT, 6, bfBold12, false, null);

			for (JobCoreModel aJob : jobList) {
				insertCell(pdfPTable, aJob.getOrganizationName(), Element.ALIGN_LEFT, 1, bf12, false, aJob);
				insertCell(pdfPTable, aJob.getDesignation(), Element.ALIGN_LEFT, 1, bf12, false, aJob);
				insertCell(pdfPTable, aJob.getQualification(), Element.ALIGN_LEFT, 1, bf12, false, aJob);
				insertCell(pdfPTable, aJob.getLocation(), Element.ALIGN_LEFT, 1, bf12, false, aJob);
				insertCell(pdfPTable, String.valueOf(aJob.getJobApplyLastDate()), Element.ALIGN_LEFT, 1, bf12, false,
						aJob);
				insertCell(pdfPTable, "Details", Element.ALIGN_JUSTIFIED, 1, bf12, false, aJob);
				
			}
			
			document.add(pdfPTable);
			document.close();
			outputStream.close();

		} catch (Exception e) {
			logger.error("Error Occured While Generating the PDF Error Message : {}",e.getLocalizedMessage());
			pdfCreation = false;
		}

		return pdfCreation;
	}

	private static void insertCell(PdfPTable table, String text, int align, int colspan, Font font, boolean isHeader,
			JobCoreModel job) {

		// create a new cell with the specified Text and Font
		PdfPCell cell = null;

		if (!text.equalsIgnoreCase("Details") || isHeader)
			cell = new PdfPCell(new Phrase(text.trim(), font));
		else {
			cell = new PdfPCell();
			Chunk c = new Chunk("Details", font);

			String encodedDesignation = UrlEscapers.urlFragmentEscaper().escape(job.getDesignation());
			String encodedOrg = UrlEscapers.urlFragmentEscaper().escape(job.getOrganizationName());

			StringBuilder urlStr = new StringBuilder(WEB_PAGE_URL);
			urlStr.append("/jobdetail").append("/").append(job.getId()).append("/").append(encodedDesignation)
					.append("/").append(encodedOrg);

			String finalURL = urlStr.toString();
			c.setAnchor(finalURL);
			cell.addElement(c);
		}

		if (isHeader) {
			cell.setBackgroundColor(new BaseColor(68, 102, 88));
		} else {
			cell.setBackgroundColor(new BaseColor(244, 251, 254));
		}
		// set the cell alignment
		cell.setHorizontalAlignment(align);
		// set the cell column span in case you want to merge two or more cells
		cell.setColspan(colspan);
		// in case there is no text and you wan to create an empty row
		if (text.trim().equalsIgnoreCase("")) {
			cell.setMinimumHeight(10f);
		}
		// add the call to the table
		table.addCell(cell);

	}
}
