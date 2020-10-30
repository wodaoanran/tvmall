package cn.yunhe.java.util;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import be.quodlibet.boxable.BaseTable;
import be.quodlibet.boxable.datatable.DataTable;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDDocumentInformation;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;

public class FileExport {
	/**
	 * 导出Excel文件
	 * 
	 * @param excelHeader
	 *            导出文件中表格头
	 * @param list
	 *            导出的内容
	 * @param response
	 *            HttpServletResponse对象，用来获得输出流向客户端写导出的文件
	 * @param sheetName
	 *            Excel的sheet名称，加上时间戳作为导出文件的名称
	 */
    public static void exportExcel(String [] excelHeader,List<Object[]> list,String sheetName,HttpServletResponse response) {    
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet = wb.createSheet(sheetName);
		HSSFRow row = sheet.createRow((int) 0);
        //设置单元格是否显示网格线
		sheet.setDisplayGridlines(false);
		
		// 设置头单元格样式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HorizontalAlignment.CENTER);
		Font fontHeader = wb.createFont();
		fontHeader.setBold(true);//Font.BOLDWEIGHT_BOLD
		fontHeader.setFontHeight((short) 240);
		style.setFont(fontHeader);
		style.setBorderBottom(BorderStyle.THIN);
		style.setBorderLeft(BorderStyle.THIN);
		style.setBorderRight(BorderStyle.THIN);
		style.setBorderTop(BorderStyle.THIN);
		
		// 设置头内容
		for (int i = 0; i < excelHeader.length; i++) {
			HSSFCell cell = row.createCell(i);
			cell.setCellValue("  " +excelHeader[i] + "  ");
			cell.setCellStyle(style);			
		}   
        
		// 设置内容单元格样式
		HSSFCellStyle styleCell = wb.createCellStyle();
		Font fontCell = wb.createFont();
		fontCell.setColor(HSSFColor.HSSFColorPredefined.BLACK.getIndex());
		styleCell.setAlignment(HorizontalAlignment.CENTER);
		styleCell.setFont(fontCell);
		styleCell.setBorderBottom(BorderStyle.THIN);
		styleCell.setBorderLeft(BorderStyle.THIN);
		styleCell.setBorderRight(BorderStyle.THIN);
		styleCell.setBorderTop(BorderStyle.THIN);
        //设置单元格内容
		for (int i = 0; i < list.size(); i++) {
			row = sheet.createRow(i + 1);
			//设置行高
			row.setHeightInPoints(20);
			Object[] obj = (Object[]) list.get(i);			
			for (int j = 0; j < excelHeader.length; j++) {
				styleCell.setWrapText(false);
            	HSSFCell cell = row.createCell(j);
				if (obj[j] != null){
					 cell.setCellValue("  " + obj[j].toString() + "  ");
				}else{
					cell.setCellValue(""); 
				}			
				//if(obj[j].toString().length()>20)
				//	styleCell.setWrapText(true);
				cell.setCellStyle(styleCell);
				sheet.autoSizeColumn(j);
            }   
        } 
		
		OutputStream ouputStream = null;
		try {
	        response.setCharacterEncoding("UTF-8");	
	        response.setContentType("application/vnd.ms-excel"); 
	        String fileName = sheetName;
	        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHMMSS");
	        fileName+=(dateFormat.format(new Date())).toString()+".xls";				
	        response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));   
	        ouputStream = response.getOutputStream();   
	        wb.write(ouputStream);     
	        ouputStream.flush();  
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
        	try {
        		if(ouputStream!=null)
        			wb.close();
        			ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
        }
    }

    //List<List> datas,
    public static void  exportPdf(List<List> datas,String pdfFileName,HttpServletResponse response) throws IOException {
    	//1.创建文档
		PDDocument document = new PDDocument();

		//2.获取文档信息对象，用来设置文档属性
		PDDocumentInformation pdd = document.getDocumentInformation();

		//3.设置文档拥有者
		pdd.setAuthor("薛建玉");
		//设置文档标题
		pdd.setTitle("测试标题");
		//设置文档作者
		pdd.setCreator("xuejy");
		//设置文档主题
		pdd.setSubject("测试赛");
		//设置文档创建时间
		Calendar date = new GregorianCalendar();
		date.set(2020, 7, 14);
		pdd.setCreationDate(date);
		//设置文档修改事件
		date.set(2020, 7, 14);
		pdd.setModificationDate(date);
		//设置文档关键字
		pdd.setKeywords("测试测试测试");

		//创建页面
		PDPage blankPage = new PDPage();

		//将页面添加到文档
		document.addPage(blankPage);

        //数据
		/*List<List> data = new ArrayList();
		data.add(new ArrayList<>(
				Arrays.asList("Column One", "Column Two", "Column Three", "Column Four", "Column Five")));
		for (int i = 1; i <= 100; i++) {
			data.add(new ArrayList<>(
					Arrays.asList("Row " + i + " Col One", "Row " + i + " Col Two", "Row " + i + " Col Three", "Row " + i + " Col Four", "Row " + i + " Col Five")));
		}*/




		//表格距页面边距
		float margin = 20;
        // starting y position is whole page height subtracted by top and bottom margin
		float yStartNewPage = blankPage.getMediaBox().getHeight() - (2 * margin);
        // we want table across whole page width (subtracted by left and right margin ofcourse)
		float tableWidth = blankPage.getMediaBox().getWidth() - (2 * margin);

		boolean drawContent = true;
		float yStart = yStartNewPage;
		float bottomMargin = 70;
        // y position is your coordinate of top left corner of the table
		float yPosition = 550;

		BaseTable dataTable = new BaseTable(yStart, yStartNewPage, bottomMargin, tableWidth,
				margin, document, blankPage, true, true);
		DataTable t = new DataTable(dataTable, blankPage);
		t.addListToTable(datas, DataTable.HASHEADER);
		dataTable.draw();

		OutputStream ouputStream = null;
		try {
			response.setCharacterEncoding("UTF-8");
			response.setContentType("application/pdf");
			String fileName = pdfFileName;
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHMMSS");
			fileName+=(dateFormat.format(new Date())).toString()+".pdf";
			response.setHeader("Content-disposition", "attachment;filename="+URLEncoder.encode(fileName, "UTF-8"));
			ouputStream = response.getOutputStream();
			document.save(ouputStream);
			ouputStream.flush();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(ouputStream!=null)
					document.close();
					ouputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	public static void main(String[] args) throws IOException {
        //exportPdf(null,null);
	}
    
   
}
