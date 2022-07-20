package framework.seven;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName BasePage
 * @Description TODO
 * @Author yangfan
 * @Date 2022/4/14 20:39
 */
public class BasePage {
    static BasePage instance = null;

    //存的是我的对象表 第一个是小名 第二个是真名  第二个参数，所有都继承于basepage，所以可以用basepage
    HashMap<String, BasePage> pages = new HashMap<>();
/*
如果你指定了一个yaml文件，我就认为说你要把一个对象存起来，存的一个对象方法，现在是basepage，我init的时候起一个短的名字，加上一个数据文件，接着读数据文件，把他里面的数据文件全部读走，他是一个二维的结构，
在上面定义一个通用的对象，跟刚才的hashmap是很像的。只不过结构体现在又变了。叫pageyamlsource
他的风格也不是basepage了，其实只要把他的数据存进来就可以了，需要一个这样的数据结构，风格也不是basepage了，其实只要把他的数据存进来就可以了，需要一个这样的数据结构，存的也是basepage，只不过多一个结构，把类给存进来，string代表短名，后面代表整个po文件，而文件是一个二维的结构，理论上来说是一个hashmap。其实严谨一点，应该是hashmap里面，比如：init是一个key，每一个value都是一个列表，所以可以定义的更细节一点，所以可以把第二个值定义的更细节一点，写成list，其实里面仍然是一个词典，list里面再包裹hashmap，只用它表示单个yaml，上面一个方法的名字，list下面又有个hashmap，通过这个办法初始化出来一个yamlsource，
*/
    //单个yaml，上面一个方法的名字，下面是一个list，里面又是一个hashmap，代表测试步骤
    HashMap<String, List<HashMap<String, Object>>> yamlSource = new HashMap<>();

    WebDriver driver;
    private SeleniumTestCase seleniumTestCase = new SeleniumTestCase();

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public BasePage() {
    }

    //这个单例是用来存我们所有这些乱七八糟的对象的，用来存所有的po。所有po本身又是basepage的一个子类。
    //用这个单例去存所有的po，所有po本身又是basepage的一个子类  小名是为了给后面的做引用
    public static BasePage getInstance() {
        if (instance == null) {
            instance = new BasePage();
        }
        return instance;
    }

    void click(By by) {
        driver.findElement(by).click();
    }

    void sendKeys(By by, String content) {
        driver.findElement(by).sendKeys(content);
    }

    /*
    首先在basepage里面，我们使用了一个poinit，传统的方法是new出来一个实例，现在是我不写类了，
    注释之后就没有类的初始化的po了。现在转成了读文件。这样我怎么去把他映射出来呢？我读yaml，
    当一个类不存在的时候，我仍然可以初始化出来一个基本的basepage，我的basepage直接new我自己的basepage就可以了，
    我自己new出来一个，不用你的，因为你的所有的方式都是继承，但是我又不想使用写代码的方式去维护我的用例了。
    我就直接初始化我的父类好了。初始化完成之后我会需要几个过程，这几个过程就是我能找到自己所有的方法，
    然后又能完成getpo，getpo里面能根据名字找到我对应的po文件，然后这个po里面还有一个steprun，
    他能跑起来我po里面的单个步骤。只要这两个有，理论上是可以跑起来的，但是每个东西怎么区分呢？
    肯定要传一个名字了，我们读取yaml，把里面的步骤
    先写一个伪代码，getpo读取main_po.yaml 然后再steprun调search。最后调的时候就是根据名字会拆解，
    中间有点，所以getpo里面要保证读到的文件是可以被记录进来的。并且说里面的步骤是可以跑起来的。
    */


    void poInit(String name, String className) {
        try {
            //动态创建类，并实例化为一个对象
            //classforname先创建出来一个类，这个时候只是一个类，还不是一个实例；我们把他赋值给一个实例的时候需要getDeclaredConstructor().newInstance()，最后放进来
//            BasePage pageClass = (BasePage) Class.forName(className).getDeclaredConstructor().newInstance();
            //classforname必须要跟包名对应
            BasePage pageClass = new BasePage();
            //jackson读出来的yaml
            /*这个时候basepage就初始化出来了，只不过这个时候呢，原来由子类来实现的代码，变成了用基类的yamlsource来代表，
            里面也是记录了yaml的所有数据结构。这样子所有的信息我们也都保存起来了，这个时候我把类放进去，以后再对这个类进行调用的时候，
            下面流程就差不多了。其中getpo找到的还是原来的basepage，只不过以前找的都是子类的mainpage searchpage，
            现在变成了一个basepage*/
            ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
            TypeReference<HashMap<String, List<HashMap<String, Object>>>> typeReference =
                    new TypeReference<HashMap<String, List<HashMap<String, Object>>>>() {
                    };
            pageClass.yamlSource = mapper.readValue(
                    //前面是一个短名，后面是一个长名
                    ParamsTest.class.getResourceAsStream(String.format("/framework/%s", className)),
                    typeReference);

//            pageClass.getPO("main_po.yaml").stepRun("search");

            pages.put(name, pageClass);
            /*
            我们在basepage里面漏了一段逻辑，我们把basepage已经放进去了，初始化的时候其实有一个driver初始化的过程，
            在原来的mainpage里面，在new的时候会创建出来这样一个对象，现在我们还没有调他。所以我们需要有一个过程去调用他。
            放进去之后还要单独调一下  steprun  里面单独调init  这个init就会完成对driver的一个初始化，接着再会调search
            改了之后浏览器就可以调起来了
             */
            pageClass.stepRun("init");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //为如何找到mainpage创建的方法  首先给个小名，就可以把名字给过来了
    BasePage getPO(String name) {
        //根据name调pages的get方法  因为整个里面存的全是po，所以返回的话是要返回一个真正的po的
        return pages.get(name);
    }

    void stepRun(String method) {
        /*
        现在变成我steprun的时候，因为你已经存了整个结构体了，所以这个时候我要去运行它，我需要有一段完整的用例，
        steprun去调方法，完成对他的一个执行。在这块就可以运行一段testcase，把他所有的方法，按照testcase这个解析，
        selenium的解析给运行起来，因为里面跑的代码全都是step这一段，所以我只需要new出来一个testcase对象，
        然后把steps传给他，尤其是seleniumtestcase就可以了。
         */


        System.out.println(method);
        /*
        steprun找方法的时候找谁呢？他调用的对象其实就是从当前的yamlsource里面首先get一下，取出来method的对象，
        method取回来是一个列表，这个列表其实就是steps要运行的那个值，所以到这步的时候我们的testcase其实就可以运行起来了。
        这个跟testcase里面的步骤是一模一样的。
         */
        List<HashMap<String, Object>> steps = yamlSource.get(method);
        //上课的时候最后遇到的问题是这块重新初始化了
        seleniumTestCase.steps = steps;
        seleniumTestCase.data = Arrays.asList("susa","lubu");
        seleniumTestCase.run();
    }

}
