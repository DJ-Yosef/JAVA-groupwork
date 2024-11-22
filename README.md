# JAVA
AI Agent调用小模型预测股票收益率

（1）采集一批股票的历史量价数据，训练一个性能良好的深度学习模型，用于预测指定股票未来3天的收益率。
（2）构建股票量价信息数据库，调用Ricequant或者Tushare等数据源实现股票量价信息数据库信息的实时更新。
（3）构建B/S模式信息系统，用户通过对大模型下达指令，大模型分析指令，并回答用户问题或执行任务。例如“请分析茅台最近一周的股价走势。”、“请预测茅台未来3天的股票收益率。”针对第一个问题，大模型可以基于数据库数据直接回答；第二个问题属于垂直领域的特定任务，大模型预测的性能往往低于自行训练的模型，针对该问题，需要在用户提出指令后，基于Agent自动调用训练的模型实现预测，并将预测结果通过前端反馈给用户。

数据源：【https://www.ricequant.com/welcome/】[https://www.ricequant.com/welcome/]【https://tushare.pro/】[https://tushare.pro/]等。

针对所有题目，模型的训练、微调等可以使用任何程序语言和工具，系统的构建需要使用Java，具体来说即构建Java Web系统。大模型通过调用API实现（如通过通义千问、Kimi、OpenAI等API），此外也可以利用LangChain等开发框架。前端使用统一提供的模板，动态交互效果等可根据小组对题目的理解自行设计。

Milvus数据库资料：
【https://blog.csdn.net/lsb2002/article/details/132222947】[https://blog.csdn.net/lsb2002/article/details/132222947]
【GitHub教程：https://github.com/milvus-io/milvus】[https://github.com/milvus-io/milvus]
【官网手册：https://milvus.io/docs】[https://milvus.io/docs]
