package com.ttxs.model.converter;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.CellData;
import com.alibaba.excel.metadata.GlobalConfiguration;
import com.alibaba.excel.metadata.property.ExcelContentProperty;
import org.apache.commons.lang3.StringUtils;

public class ExportModelConverter implements Converter<String> {
    @Override
    public Class supportJavaTypeKey() {
        return String.class;
    }

    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    /**
     * 这里是读的时候会调用 不用管
     *
     * @param cellData NotNull
     * @param contentProperty Nullable
     * @param globalConfiguration NotNull
     * @return 单元格数据
     */
    @Override
    public String convertToJavaData(CellData cellData, ExcelContentProperty contentProperty,
                                    GlobalConfiguration globalConfiguration) {
        return cellData.getStringValue();
    }

    /**
     * 这里是写的时候会调用 不用管
     *
     * @param value NotNull
     * @param contentProperty Nullable
     * @param globalConfiguration NotNull
     * @return 单元格数据
     */
    @Override
    public CellData convertToExcelData(String value, ExcelContentProperty contentProperty,
                                       GlobalConfiguration globalConfiguration) {
        if(value!=null){
            if ("5".equals(value)) {
                return new CellData("wozhuanhuanle ");
            }
        }

        return new CellData(value);
    }

}
