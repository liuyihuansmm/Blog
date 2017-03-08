package org.cn.lyh.util.tag;

/**
 * Created by LYH on 2017/3/2.
 */

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.SimpleTagSupport;
import java.io.IOException;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class ByteToStringTag extends SimpleTagSupport {

    private byte[] content;

    public void setContent(byte[] content) {
        this.content = content;
    }

    private byte[] summary;

    public void setSummary(byte[] summary) {
        this.summary = summary;
    }

    @Override
    public void doTag() throws JspException, IOException {
        JspWriter out = getJspContext().getOut();
        if (content != null){
            out.write(new String(content,"UTF-8"));
        }
        if (summary !=null){
            String strTxt = replaceHtml(new String(summary,"UTF-8"));
            if(strTxt.length()>50){
                out.write(strTxt.substring(0,50));
            }else{
                out.write(strTxt.substring(0,strTxt.length()));
            }
        }

    }

    public String replaceHtml(String htmlStr){
        String regEx_script="<script[^>]*?>[\\s\\S]*?<\\/script>"; //定义script的正则表达式
        String regEx_style="<style[^>]*?>[\\s\\S]*?<\\/style>"; //定义style的正则表达式
        String regEx_html="<[^>]+>"; //定义HTML标签的正则表达式

        Pattern p_script=Pattern.compile(regEx_script,Pattern.CASE_INSENSITIVE);
        Matcher m_script=p_script.matcher(htmlStr);
        htmlStr=m_script.replaceAll(""); //过滤script标签

        Pattern p_style=Pattern.compile(regEx_style,Pattern.CASE_INSENSITIVE);
        Matcher m_style=p_style.matcher(htmlStr);
        htmlStr=m_style.replaceAll(""); //过滤style标签

        Pattern p_html=Pattern.compile(regEx_html,Pattern.CASE_INSENSITIVE);
        Matcher m_html=p_html.matcher(htmlStr);
        htmlStr=m_html.replaceAll(""); //过滤html标签

        return htmlStr.trim(); //返回文本字符串
    }
}
