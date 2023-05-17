package listener;

import com.alibaba.excel.context.AnalysisContext;
import com.alibaba.excel.event.AnalysisEventListener;
import entity.Card;
import service.CardService;
import service.impl.CardServiceImpl;

import javax.servlet.annotation.*;
import java.util.Map;

@WebListener
public class ExcelListener extends AnalysisEventListener<Card> {


    CardService service = new CardServiceImpl();


    @Override
    public void invoke(Card card, AnalysisContext analysisContext) {
        service.AddOne(card);
    }

    @Override
    public void doAfterAllAnalysed(AnalysisContext analysisContext) {



    }
}
