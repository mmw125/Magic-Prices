package magicPrices;

import java.util.List;

import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlPage;
import com.gargoylesoftware.htmlunit.html.HtmlTable;
import com.gargoylesoftware.htmlunit.html.HtmlTableCell;
import com.gargoylesoftware.htmlunit.html.HtmlTableRow;

public class GetElements {
        public GetElements(){
                getEle();
        }
        public void getEle(){
                AppWindow window = new AppWindow();
                String setPre = "bfz";
                String language = "en";
                String defaultWebAddress = "http://magiccards.info/"+setPre+"/"+language+"/";
                for(int count = 1; count < 265; count++){
                        try {
                                String[] nameAP = getCardname(defaultWebAddress+count);
                                for(int a = 0; a < nameAP.length; a++){
                                        System.out.println();
                                }
                                String price = nameAP[2].substring(1);
                                System.out.println(price);
                                if(Float.parseFloat(price)>1){
                                window.addData(nameAP, setPre, count);
                                }
                        } catch (Exception e) {
                                e.printStackTrace();
                        }
                }
                
        }
        
        public static void main(String[] args) throws Exception {
                GetElements elements = new GetElements();      
        }
        
        public double[] getPrices(String webAddress){
                double[] pricesDou = new double[3];
                final WebClient webClient = new WebClient();
            HtmlPage page = null;
            String[] prices = new String[3];
                try {
                        page = webClient.getPage(webAddress);
                } catch (Exception e) {
                        System.out.println("Invalid web address");
                        e.printStackTrace();
                }
                try{
                        final HtmlTable table = page.getHtmlElementById("TCGPHiLoTable");
                        final List<HtmlTableRow> row = table.getRows();
                        final List<HtmlTableCell> cell = row.get(0).getCells();
                        for(int count = 0; count < 3; count ++){
                                prices[count] = cell.get(count).asText();
                        }
                        for(int a = 0; a < 3; a++){
                                prices[a] = prices[a].substring(4);
                                pricesDou[a] = Double.parseDouble(prices[a]);
                                System.out.println(prices[a]);
                        }
                }catch(Exception e){}
                
                return pricesDou;
        }
        public String[] getCardname(String webAddress){
                String[] nameAndPrices = new String[4];
                final WebClient webClient = new WebClient();
            HtmlPage page = null;
                try {
                        page = webClient.getPage(webAddress+".html");
                } catch (Exception e) {
                        System.out.println("Invalid web address");
                        e.printStackTrace();
                }
                try{
                        final HtmlTable table = page.getHtmlElementById("TCGProductPriceLowHigh");
                        final List<HtmlTableRow> row = table.getRows();
                        final List<HtmlTableCell> cell = row.get(1).getCells();
                        for(int count = 0; count < 4; count ++){
                                nameAndPrices[count] = cell.get(count).asText();
                        }
                        
                }catch(Exception e){}
                return nameAndPrices;
        }
}