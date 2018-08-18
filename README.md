# JavaBasis
最近在准备面试，刷一遍基础知识

JDK 结构
![](https://ws3.sinaimg.cn/large/006tKfTcgy1fqzhbmij4mj31dw0gewz4.jpg)

1 . public 修饰 class 问题

若一个类文件（*.java）文件中存在多个 java 类，public 修饰的类名称必须和类文件文件名一致，且一个类文件中只能存在一个被 public 修饰的类，类文件中有多少个类编译后就会有多少个 .class 文件

2 . 数据类型

![](https://ws2.sinaimg.cn/large/006tKfTcgy1fqzjaj8euvj31bc0hqta6.jpg)

* [JVM 规范中，boolean 变量作为 int 处理，也就是4字节；boolean 数组当做 byte 数组处理](https://www.jianshu.com/p/2f663dc820d0)
* 1字节是8位，首位位符号位，所以一字节最大存储 +/-127
* 使用时注意数据边界就可以
* 浮点型计算精度问题
* [原码、反码、补码详解](https://www.cnblogs.com/zhangziqiu/archive/2011/03/30/ComputerCode.html)

``` java
a. Java 是严格区分大小写的，那给 float、double、long 赋值时，后面的符号大小写有什么区别？
b. 基本数据类型底层也是对象，所以说 Java 是一门彻头彻尾的面向对象的编程语言。`__``__`
```

3 . [异或运算](http://www.cnblogs.com/JhSonD/p/6374397.html)

4 . [从内存模型理解下值传递](https://www.zhihu.com/question/31203609)

5 . [八大排序算法总结](https://itimetraveler.github.io/2017/07/18/%E5%85%AB%E5%A4%A7%E6%8E%92%E5%BA%8F%E7%AE%97%E6%B3%95%E6%80%BB%E7%BB%93%E4%B8%8Ejava%E5%AE%9E%E7%8E%B0/#%E6%A6%82%E8%BF%B0)

6 . [Java写一套漂亮的代码](https://www.zhihu.com/question/39972591)

7 . [JAVA设计模式总结之23种设计模式](https://www.cnblogs.com/pony1223/p/7608955.html)

8 . [枚举单例](https://www.cnblogs.com/cielosun/p/6596475.html)

9 . [IO 操作](https://blog.csdn.net/wei_zhi/article/details/52933233)

![](https://ws4.sinaimg.cn/large/006tKfTcgy1fr6ekuxv65j30ml0dwk49.jpg)

10 . [多线程](https://blog.csdn.net/evankaka/article/details/44153709)

* 想要执行某个对象的 notify(), notifyAll(),wait() 方法就必须获取该对象的锁，避免 IllegalMonitorStateException 异常

11 . [三种多线程实现方式](https://my.oschina.net/Tsher2015/blog/487277)

12 . 函数式编程

从以下几个方面彻底搞懂 Java 中的函数式编程

* lambda 表达式 (lambda 返回的是一个指定接口的对象实例)  
  * lambda 类型推断  
  * lambda 变量引用
  
* 函数接口 （理解函数是一种对象）

![内置函数](https://ws2.sinaimg.cn/large/006tNbRwly1fue8da3fvnj31kw0yu1kx.jpg)

* 方法引用  (重点关注方法的输入输出)  
  * 静态方法引用
  * 构造方法引用
  * 成员方法引用，使用实例对象的方法引用
  * 成员方法引用，使用类名的方法引用
  
* 流编程 （jdk 8 中提供的流编程 API）  
  * 流的创建
  * 流的操作方法(中间流操作/终止流操作（常用的收集器，了解 stream 运行机制，了解有状态的流操作对整个流执行顺序的影响）)
  * 并行流

|作用位置| 说明                                   | 示例方法 |
|:------| :-------------------------------------- | :------------------------------------------------------------ |
|无状态中间流| 无状态流操作：当前操作与其他元素没有关系     | map/mapToXxx、flatMap/flatMapXxx、filter、peek、unordered |
|有状态中间流| 有状态流操作：当前操作依赖其他元素（比如排序，去重） | sorted、distinct、limit、skip                             |
|非短路终止流| 非短路操作：等待所有结果执行完成 | forEach/forEachOrdered、collect/toArray、reduce、min/max/count |
|短路终止流| 短路操作：不需要等待所有结果计算完的终止流操作 | findFirst/findAny、allMatch/anyMatch/noneMatch |

**流的运行原理**
1. 所有的操作都是链式操作，一个元素只迭代一次
2. 每一个中间操作返回一个新的流（parallel/sequetial 除外，他们只修改 Head 的并行状态），流里面有一个熟悉 sourceStage 指向同一个地方 Head （Head -> nextStage -> nextStage -> ... -> null) 流执行完毕
3. 有状态的操作会把流截断（并行操作下，有状态的流也是串行执行的）

[Java 8 中的 Streams API 详解](https://www.ibm.com/developerworks/cn/java/j-lo-java8streamapi/index.html)

扩展：级联表达式与[柯里化](https://zh.wikipedia.org/wiki/柯里化)