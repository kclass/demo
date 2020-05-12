package com.ttxs.Vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.List;

/**
 * @author kai.hu
 * @date 2020/5/7 17:30
 */
@Data
@Accessors(chain = true)
public class MultipartExportVo {
    /**
     * 导出model的class对象，生成表头、样式等
     */
    private Class modelClass;

    /**
     * 数据
     */
    private List records;

    /**
     * sheet名称
     */
    private String sheetName;
}
