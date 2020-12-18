
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;

public class CreateXL {
    /** Excel �ļ�Ҫ��ŵ�λ�ã��ٶ���F����*/
    public static String outputFile = "E:\\test.xls";
    public static void main(String argv[]) {
        try {
// �����µ�Excel ������
            HSSFWorkbook workbook = new HSSFWorkbook();
            // ��Excel�������н�һ����������Ϊȱʡֵ
            // ��Ҫ�½�һ��Ϊ"Ч��ָ��"�Ĺ����������Ϊ��
            HSSFSheet sheet = workbook.createSheet("ѧ���ɼ�");
            // ������0��λ�ô����У���˵��У�
            HSSFRow row00 = sheet.createRow((short)0);
            //������0��λ�ô�����Ԫ�����϶ˣ�
            HSSFCell cell01 = row00.createCell((short)0);

        HSSFCell cell02 = 
            row00.createCell((short)1);

            // �ڵ�Ԫ��������һЩ����
            cell01.setCellValue("��Ŀ");
        cell02.setCellValue("����");

        //����
        HSSFRow row01 = sheet.createRow((short)1);

            HSSFCell cell11 = row01.createCell((short)0);

            HSSFCell cell12 = row01.createCell((short)1);

            cell11.setCellValue("����");
        cell12.setCellValue("90");

            //��ѧ
            H0SSFRow row02 = sheet.createRow((short)2);

            HSSFCell cell21 = row02.createCell((short)0);

            HSSFCell cell22 = row02.createCell((short)1);

            cell21.setCellValue("��ѧ");
        cell22.setCellValue("99");

            //Ӣ��
            HSSFRow row03 = sheet.createRow((short)3);

            HSSFCell cell31 = row03.createCell((short)0);

            HSSFCell cell32 = row03.createCell((short)1);

            cell31.setCellValue("Ӣ��");
        cell32.setCellValue("98");

            // �½�һ����ļ���
            FileOutputStream fOut = new 
            FileOutputStream(outputFile);
            // ����Ӧ��Excel ����������
            workbook.write(fOut);
            fOut.flush();
            // �����������ر��ļ�
            fOut.close();
            System.out.println("�ļ�����...");
        } catch (Exception e) {
            System.out.println("������ xlCreate() : " + e);
  }
 }
}