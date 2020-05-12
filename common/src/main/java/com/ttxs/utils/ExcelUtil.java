package com.ttxs.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.builder.ExcelWriterSheetBuilder;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.style.AbstractCellStyleStrategy;
import com.ttxs.model.BaseExportModel;
import com.ttxs.Vo.MultipartExportVo;

import java.lang.reflect.Method;
import java.util.List;

/**
 * @author kai.hu
 * @date 2020/5/7 17:22
 */
public class ExcelUtil {

    public static String writeEasyMultipartExcel(String fileName, List<MultipartExportVo> data) {
        if (data != null && data.size() > 0) {
            ExcelWriter excelWriter = EasyExcel.write(fileName).build();
            int sheetNo = 0;
            for (MultipartExportVo vo : data) {
                Class classType = vo.getModelClass();
                try {
                    ExcelWriterSheetBuilder writerSheetBuilder = EasyExcel.writerSheet(sheetNo++, vo.getSheetName()).head(classType);
                    Object instance = classType.newInstance();
                    if (instance instanceof BaseExportModel) {
                        Method styleMethod = vo.getModelClass().getMethod("getCellStyleStrategy");
                        AbstractCellStyleStrategy cellStyleStrategy = (AbstractCellStyleStrategy) styleMethod.invoke(instance);
                        writerSheetBuilder.registerWriteHandler(cellStyleStrategy);
                    }
                    WriteSheet writeSheet = writerSheetBuilder.build();
                    List beans = ConvertUtil.mapsToBeans(vo.getRecords(),classType);
                    excelWriter.write(beans, writeSheet);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            excelWriter.finish();
            return fileName;
        } else {
            return null;
        }

    }
}
