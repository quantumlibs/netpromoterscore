# netpromoterscore
NPS android library helps you to get the feedback you need from the users

### Gradle Dependency: 
implementation 'com.github.quantumlibs:netpromoterscore:0.1.5'

### Adding NPS layout in XML

<?xml version="1.0" encoding="utf-8"?>

    <lib.quantum.nps.NPSRecyclerView
        android:id="@+id/nps_rv"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_below="@+id/text"
        android:orientation="horizontal"
        android:layout_centerHorizontal="true"
        app:shape="square"
        app:count="10"/>
        
### Set layout attributes
  
* *for number of boxes*

  __app:count="10"__
  
* *set answer from layout*

  __app:answer="3"__
  
* *set answer from layout*

  __app:shape="square"__ or  __app:shape="circle"__
  
> Square type

  <img src="https://user-images.githubusercontent.com/12711403/168563474-efe46149-93eb-45d6-b677-241d44889db9.jpg" width="400" height="121">

> Circle type

  <img src="https://user-images.githubusercontent.com/12711403/168563481-5dd1fd31-0d16-4365-95ff-2078e4c360fa.jpg" width="400" height="121">

### Set Selected Answer

    npsRV.setSelectedAnswer(1)
    
### Get Selected Answer

    npsRV.getSelectedAnswer()

### AnswerSelected Listener

    npsRV.OnSelectAnswerListner(object : NPSRecyclerView.NPSAnswerSelectedListener {
            
            override fun onAnswerSelected(npsAnswer: Int) {
                Toast.makeText(context, ""+npsAnswer, Toast.LENGTH_SHORT).show()
            }
        })
