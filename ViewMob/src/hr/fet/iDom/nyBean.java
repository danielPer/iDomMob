package hr.fet.iDom;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.share.ADFContext;

import oracle.binding.BindingContainer;

import org.apache.myfaces.trinidad.component.core.nav.CoreCommandLink;

@ManagedBean(name="myBean")
@RequestScoped
public class nyBean {
    public nyBean() {
    }

    public void setCurrent(ActionEvent actionEvent) {
        System.out.println("dsdsadsad");
        CoreCommandLink comp = (CoreCommandLink)actionEvent.getComponent();
        Integer roomId = (Integer)comp.getAttributes().get("roomId");
                
        ADFContext adfCtx = ADFContext.getCurrent();
        Map pageFlowScope = adfCtx.getPageFlowScope();
        pageFlowScope.put("roomId", roomId);
        
        
        //getBindings().getOperationBinding("ExecuteWithParamsZakupi").execute();
    }
    
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
}
