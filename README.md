
1
org.springframework.beans.NotReadablePropertyException: Invalid property 'isReplaceImgUrl' of bean class [com.velogexport.velogexport.domain.VelogDetail]: Bean property 'isReplaceImgUrl' is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?
```java
@Data
public class VelogDetail {
    private String id;
    private boolean isReplaceImgUrl;
}
```
```
Caused by: org.springframework.beans.NotReadablePropertyException: Invalid property 'isReplaceImgUrl' of bean class [com.velogexport.velogexport.domain.VelogDetail]: Bean property 'isReplaceImgUrl' is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?
	at org.springframework.beans.AbstractNestablePropertyAccessor.getPropertyValue(AbstractNestablePropertyAccessor.java:627) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.AbstractNestablePropertyAccessor.getPropertyValue(AbstractNestablePropertyAccessor.java:617) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.validation.AbstractPropertyBindingResult.getActualFieldValue(AbstractPropertyBindingResult.java:105) ~[spring-context-6.2.5.jar:6.2.5]
	at org.springframework.validation.AbstractBindingResult.getFieldValue(AbstractBindingResult.java:225) ~[spring-context-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.support.BindStatus.<init>(BindStatus.java:129) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.support.RequestContext.getBindStatus(RequestContext.java:928) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.thymeleaf.spring6.context.webmvc.SpringWebMvcThymeleafRequestContext.getBindStatus(SpringWebMvcThymeleafRequestContext.java:232) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.util.FieldUtils.getBindStatusFromParsedExpression(FieldUtils.java:306) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.util.FieldUtils.getBindStatus(FieldUtils.java:253) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.util.FieldUtils.getBindStatus(FieldUtils.java:227) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.processor.AbstractSpringFieldTagProcessor.doProcess(AbstractSpringFieldTagProcessor.java:174) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractAttributeTagProcessor.doProcess(AbstractAttributeTagProcessor.java:74) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	... 63 common frames omitted

2025-04-09T16:54:39.636+09:00 ERROR 8970 --- [velog-export] [nio-8080-exec-1] o.a.c.c.C.[.[.[/].[dispatcherServlet]    : Servlet.service() for servlet [dispatcherServlet] in context with path [] threw exception [Request processing failed: org.thymeleaf.exceptions.TemplateInputException: An error happened during template parsing (template: "class path resource [templates/index.html]")] with root cause

org.springframework.beans.NotReadablePropertyException: Invalid property 'isReplaceImgUrl' of bean class [com.velogexport.velogexport.domain.VelogDetail]: Bean property 'isReplaceImgUrl' is not readable or has an invalid getter method: Does the return type of the getter match the parameter type of the setter?
	at org.springframework.beans.AbstractNestablePropertyAccessor.getPropertyValue(AbstractNestablePropertyAccessor.java:627) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.beans.AbstractNestablePropertyAccessor.getPropertyValue(AbstractNestablePropertyAccessor.java:617) ~[spring-beans-6.2.5.jar:6.2.5]
	at org.springframework.validation.AbstractPropertyBindingResult.getActualFieldValue(AbstractPropertyBindingResult.java:105) ~[spring-context-6.2.5.jar:6.2.5]
	at org.springframework.validation.AbstractBindingResult.getFieldValue(AbstractBindingResult.java:225) ~[spring-context-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.support.BindStatus.<init>(BindStatus.java:129) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.support.RequestContext.getBindStatus(RequestContext.java:928) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.thymeleaf.spring6.context.webmvc.SpringWebMvcThymeleafRequestContext.getBindStatus(SpringWebMvcThymeleafRequestContext.java:232) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.util.FieldUtils.getBindStatusFromParsedExpression(FieldUtils.java:306) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.util.FieldUtils.getBindStatus(FieldUtils.java:253) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.util.FieldUtils.getBindStatus(FieldUtils.java:227) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.processor.AbstractSpringFieldTagProcessor.doProcess(AbstractSpringFieldTagProcessor.java:174) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractAttributeTagProcessor.doProcess(AbstractAttributeTagProcessor.java:74) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.processor.element.AbstractElementTagProcessor.process(AbstractElementTagProcessor.java:95) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.util.ProcessorConfigurationUtils$ElementTagProcessorWrapper.process(ProcessorConfigurationUtils.java:633) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.ProcessorTemplateHandler.handleStandaloneElement(ProcessorTemplateHandler.java:918) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.TemplateHandlerAdapterMarkupHandler.handleStandaloneElementEnd(TemplateHandlerAdapterMarkupHandler.java:260) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.templateparser.markup.InlinedOutputExpressionMarkupHandler$InlineMarkupAdapterPreProcessorHandler.handleStandaloneElementEnd(InlinedOutputExpressionMarkupHandler.java:256) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.standard.inline.OutputExpressionInlinePreProcessorHandler.handleStandaloneElementEnd(OutputExpressionInlinePreProcessorHandler.java:169) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.templateparser.markup.InlinedOutputExpressionMarkupHandler.handleStandaloneElementEnd(InlinedOutputExpressionMarkupHandler.java:104) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.attoparser.HtmlElement.handleStandaloneElementEnd(HtmlElement.java:79) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.attoparser.HtmlMarkupHandler.handleStandaloneElementEnd(HtmlMarkupHandler.java:241) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.attoparser.MarkupEventProcessorHandler.handleStandaloneElementEnd(MarkupEventProcessorHandler.java:327) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.attoparser.ParsingElementMarkupUtil.parseStandaloneElement(ParsingElementMarkupUtil.java:96) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.attoparser.MarkupParser.parseBuffer(MarkupParser.java:706) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.attoparser.MarkupParser.parseDocument(MarkupParser.java:301) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.attoparser.MarkupParser.parse(MarkupParser.java:257) ~[attoparser-2.0.7.RELEASE.jar:2.0.7.RELEASE]
	at org.thymeleaf.templateparser.markup.AbstractMarkupTemplateParser.parse(AbstractMarkupTemplateParser.java:230) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.templateparser.markup.AbstractMarkupTemplateParser.parseStandalone(AbstractMarkupTemplateParser.java:100) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.engine.TemplateManager.parseAndProcess(TemplateManager.java:666) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1103) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.TemplateEngine.process(TemplateEngine.java:1077) ~[thymeleaf-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.view.ThymeleafView.renderFragment(ThymeleafView.java:372) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.thymeleaf.spring6.view.ThymeleafView.render(ThymeleafView.java:192) ~[thymeleaf-spring6-3.1.3.RELEASE.jar:3.1.3.RELEASE]
	at org.springframework.web.servlet.DispatcherServlet.render(DispatcherServlet.java:1437) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.DispatcherServlet.processDispatchResult(DispatcherServlet.java:1168) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1106) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:979) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1014) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at org.springframework.web.servlet.FrameworkServlet.doGet(FrameworkServlet.java:903) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:564) ~[tomcat-embed-core-10.1.39.jar:6.0]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:885) ~[spring-webmvc-6.2.5.jar:6.2.5]
	at jakarta.servlet.http.HttpServlet.service(HttpServlet.java:658) ~[tomcat-embed-core-10.1.39.jar:6.0]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:195) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:51) ~[tomcat-embed-websocket-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-6.2.5.jar:6.2.5]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.5.jar:6.2.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-6.2.5.jar:6.2.5]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.5.jar:6.2.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-6.2.5.jar:6.2.5]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:116) ~[spring-web-6.2.5.jar:6.2.5]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:164) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:140) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:167) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:90) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:483) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:115) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:93) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:74) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:344) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:397) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:63) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:905) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1743) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:52) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1190) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.tomcat.util.threads.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:659) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:63) ~[tomcat-embed-core-10.1.39.jar:10.1.39]
	at java.base/java.lang.Thread.run(Thread.java:842) ~[na:na]
```
원인 : boolean 필드의 Getter 이름이 Java Bean 명명 규칙과 Spring 바인딩 처리 방식 사이에서 충돌나기 때문입니다.

VelogDetail.isReplaceImgUrl로 사용하기 때문에 
