package com.wewe.excel;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;

import java.io.FileOutputStream;


/**
 * Created by fei2 on 2018/1/13.
 */
public class CreateSimpleExcelToDisk {

	public static void main(String[] args) throws Exception
	{
		// 第一步，创建一个webbook，对应一个Excel文件
		HSSFWorkbook wb = new HSSFWorkbook();

		// 创建一个居中格式
		HSSFCellStyle style = wb.createCellStyle();
		style.setAlignment(HSSFCellStyle.ALIGN_CENTER);
//		style.setAlignment(HSSFCellStyle.VERTICAL_CENTER);

		// 第二步，在webbook中添加一个sheet,对应Excel文件中的sheet
		HSSFSheet sheet = wb.createSheet("sheet1");
		//第三步，在sheet中添加表头第0行
		HSSFRow row = sheet.createRow(0);
		//第一行
		//合并列
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("厦门地铁项目");
		cell.setCellStyle(style);
		CellRangeAddress region=new CellRangeAddress(0, 0, 0, 19);
		sheet.addMergedRegion(region);

		//第二行
		row = sheet.createRow(1);

		cell = row.createCell(0);
		cell.setCellValue("列车号");
		cell.setCellStyle(style);
		CellRangeAddress liecheHaoregion=new CellRangeAddress(1, 3, 0, 0);
		sheet.addMergedRegion(region);

		cell = row.createCell(1);
		cell.setCellValue("辆号");
		cell.setCellStyle(style);
		region=new CellRangeAddress(1, 3, 1, 1);
		sheet.addMergedRegion(region);

		cell = row.createCell(2);
		cell.setCellValue("工序");
		cell.setCellStyle(style);
		CellRangeAddress gongXuregion=new CellRangeAddress(1, 1, 2, 19);
		sheet.addMergedRegion(region);
		//第三行
		row = sheet.createRow(2);

		cell = row.createCell(2);
		cell.setCellValue("车体");
		cell.setCellStyle(style);
		region=new CellRangeAddress(2, 2, 2, 4);
		sheet.addMergedRegion(region);

		cell = row.createCell(5);
		cell.setCellValue("涂装");
		cell.setCellStyle(style);
		region=new CellRangeAddress(2, 2, 5, 7);
		sheet.addMergedRegion(region);

		cell = row.createCell(8);
		cell.setCellValue("总组装");
		cell.setCellStyle(style);
		region=new CellRangeAddress(2, 2, 8, 10);
		sheet.addMergedRegion(region);

		cell = row.createCell(11);
		cell.setCellValue("落车");
		cell.setCellStyle(style);
		region=new CellRangeAddress(2, 2, 11, 13);
		sheet.addMergedRegion(region);

		cell = row.createCell(14);
		cell.setCellValue("单调");
		cell.setCellStyle(style);
		region=new CellRangeAddress(2, 2, 14, 16);
		sheet.addMergedRegion(region);

		cell = row.createCell(17);
		cell.setCellValue("列调");
		cell.setCellStyle(style);
		region=new CellRangeAddress(2, 2, 17, 19);
		sheet.addMergedRegion(region);

		//第四行
		row = sheet.createRow(3);

		cell = row.createCell(2);
		cell.setCellValue("计划完工");
		cell.setCellStyle(style);
		cell = row.createCell(3);
		cell.setCellValue("实际完工");
		cell.setCellStyle(style);
		cell = row.createCell(4);
		cell.setCellValue("计划偏差");
		cell.setCellStyle(style);

		cell = row.createCell(5);
		cell.setCellValue("计划完工");
		cell.setCellStyle(style);
		cell = row.createCell(6);
		cell.setCellValue("实际完工");
		cell.setCellStyle(style);
		cell = row.createCell(7);
		cell.setCellValue("计划偏差");
		cell.setCellStyle(style);


		cell = row.createCell(8);
		cell.setCellValue("计划完工");
		cell.setCellStyle(style);
		cell = row.createCell(9);
		cell.setCellValue("实际完工");
		cell.setCellStyle(style);
		cell = row.createCell(10);
		cell.setCellValue("计划偏差");
		cell.setCellStyle(style);


		cell = row.createCell(11);
		cell.setCellValue("计划完工");
		cell.setCellStyle(style);
		cell = row.createCell(12);
		cell.setCellValue("实际完工");
		cell.setCellStyle(style);
		cell = row.createCell(13);
		cell.setCellValue("计划偏差");
		cell.setCellStyle(style);


		cell = row.createCell(14);
		cell.setCellValue("计划完工");
		cell.setCellStyle(style);
		cell = row.createCell(15);
		cell.setCellValue("实际完工");
		cell.setCellStyle(style);
		cell = row.createCell(16);
		cell.setCellValue("计划偏差");
		cell.setCellStyle(style);

		cell = row.createCell(17);
		cell.setCellValue("计划完工");
		cell.setCellStyle(style);
		cell = row.createCell(18);
		cell.setCellValue("实际完工");
		cell.setCellStyle(style);
		cell = row.createCell(19);
		cell.setCellValue("计划偏差");
		cell.setCellStyle(style);


		setBorder(region,sheet,wb);
		setBorder(liecheHaoregion,sheet,wb);
		setBorder(gongXuregion,sheet,wb);

		double value = Math.random();

		// 第六步，将文件存到指定位置
		try
		{
			FileOutputStream fout = new FileOutputStream("/home/wewe/"+value+".xls");
			wb.write(fout);
			fout.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	//合并单元格设置边框
	public static void setBorder(CellRangeAddress cellRangeAddress, Sheet sheet,
								  Workbook wb) throws Exception {
		RegionUtil.setBorderLeft(1, cellRangeAddress, sheet, wb);
		RegionUtil.setBorderBottom(1, cellRangeAddress, sheet, wb);
		RegionUtil.setBorderRight(1, cellRangeAddress, sheet, wb);
		RegionUtil.setBorderTop(1, cellRangeAddress, sheet, wb);

	}
}
