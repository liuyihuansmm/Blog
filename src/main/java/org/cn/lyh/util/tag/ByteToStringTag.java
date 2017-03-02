package org.cn.lyh.util.tag;

/**
 * Created by LYH on 2017/3/2.
 */

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;

public class ByteToStringTag extends SimpleTagSupport {

    private byte[] content;

    public void setContent(byte[] content) {
        this.content = content;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        out.write(new String(content,"UTF-8"));
    }
}
