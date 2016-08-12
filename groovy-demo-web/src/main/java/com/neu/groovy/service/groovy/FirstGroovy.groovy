package com.neu.groovy.service.groovy

/**
 * @description
 * @author guojiang.xiong@dmall.com
 * @since 2016-07-29 10:50
 */

List<String> list = new ArrayList<String>();
list.add("a");
list.add("b");
println list;

def map = ['x':1,'y':4]
map.put("a", 8);

String[] array = ["1","2","3"];
List<String> arrayList = Arrays.asList(array);
println map;
println arrayList;

//循环打印
for (i in arrayList){
    println("groovy:$i");
}

//打印三次
3.times {
    println 'Java的东西Groovy都能用'
}

println "hello groovy," /* 我是块注释 */ + "my name is guojiang.xiong."

println('''
   1. fdkfj;
   2. fdf.
   3......
''')

assert 2 <= 3
assert 7 <= 9
assert 7 != 2
assert true
assert 2 > 3 || 7 <= 9
assert ( 2 > 3 || 4 < 5 ) && 6 != 7


x = 1
println x

x = new Date()
println x

x = -3.1499392
println x

x = false
println x

x = "Hi"
println x


def xmlText = """
              | <root>
              |   <level>
              |      <sublevel id='1'>
              |        <keyVal>
              |          <key>mykey</key>
              |          <value>value 123</value>
              |        </keyVal>
              |      </sublevel>
              |      <sublevel id='2'>
              |        <keyVal>
              |          <key>anotherKey</key>
              |          <value>42</value>
              |        </keyVal>
              |        <keyVal>
              |          <key>mykey</key>
              |          <value>fizzbuzz</value>
              |        </keyVal>
              |      </sublevel>
              |   </level>
              | </root>
              """
println xmlText