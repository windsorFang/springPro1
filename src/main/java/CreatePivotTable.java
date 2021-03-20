
import com.spire.xls.*;

public class CreatePivotTable {

    public static void main(String[] args)  {

        //加载示例文档
        Workbook workbook = new Workbook();
        workbook.loadFromFile("Sample.xlsx");

        //获取第一个工作表
        Worksheet sheet = workbook.getWorksheets().get(0);

        //为需要汇总和创建分析的数据创建缓存
        CellRange dataRange = sheet.getCellRange("B1:D11");
        PivotCache cache = workbook.getPivotCaches().add(dataRange);

        //使用缓存创建数据透视表，并指定透视表的名称以及在工作表中的位置
        PivotTable pt = sheet.getPivotTables().add("Pivot Table", sheet.getCellRange("F4"), cache);

        //添加行字段
        PivotField pf=null;
        if (pt.getPivotFields().get("区域") instanceof PivotField){
            pf= (PivotField) pt.getPivotFields().get("区域");
        }
        pf.setAxis(AxisTypes.Row);
        PivotField pf2 =null;
        if (pt.getPivotFields().get("商品") instanceof PivotField){
            pf2= (PivotField) pt.getPivotFields().get("商品");
        }
        pf2.setAxis(AxisTypes.Row);

        //添加值字段
        pt.getDataFields().add(pt.getPivotFields().get("金额"), "求和项：金额", SubtotalTypes.Sum);

        //设置透视表样式
        pt.setBuiltInStyle(PivotBuiltInStyles.PivotStyleMedium12);

        //保存文档
        workbook.saveToFile("透视表.xlsx", ExcelVersion.Version2013);
    }
}
