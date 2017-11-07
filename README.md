[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SquareRatingView-green.svg?style=flat )]( https://android-arsenal.com/details/1/6420 )


<a href='https://ko-fi.com/A116514N' target='_blank'><img height='36' style='border:0px;height:36px;' src='https://az743702.vo.msecnd.net/cdn/kofi2.png?v=0' border='0' alt='Buy Me a Coffee at ko-fi.com' /></a>



# SquareRatingView

**SquareRatingView** is a Custom RatingBar component that allows you to customise your rating view with any image or by default with green and grey tiles. RatingBar by default is a star icon and is little tricky while changing the icon to any other icon. SquareRatingView is here to solve the problem. 


Example I |      Example II
-------- | ---
![Library screen](https://github.com/ashokslsk/SquareRatingView/blob/master/screens/Animated.gif)|![Library screen](https://github.com/ashokslsk/SquareRatingView/blob/master/screens/Redico.gif)
  


How to use
----------

#Installation

```gradle

 
 //Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}

dependencies {
	        compile 'com.github.ashokslsk:SquareRatingView:1.2'
	}
```

## In your xml add the following code to see the default square rating view

```xml
 
<com.ashokslsk.androidabcd.squarerating.SquareRatingView
        android:id="@+id/square"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:setNumSquare="8"
        app:setRating="0"
        app:setStepSize="0.5" />

```


## In your xml add the following square rating view for drawable image

```xml
 <com.ashokslsk.androidabcd.squarerating.SquareRatingView
        android:id="@+id/square"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:setNumSquare="8"
        app:setRating="0"
        app:setSelectedResource="@mipmap/ic_launcher"        // Your selected drawable resource
        app:setUnSelectedResource="@mipmap/ic_launcher_round" // Your unselected drawable resource
        app:setStepSize="0.5" />

```

## Use the following values for customising the rating tiles and stepsizes. 

        app:setNumSquare="8"
        app:setRating="0"
        app:setStepSize="0.5"
        app:setSelectedResource="@mipmap/ic_launcher"
        app:setUnSelectedResource="@mipmap/ic_launcher_round"

# JAVA Controls

```java
 mRatingView = (SquareRatingView) findViewById(R.id.square);
        mRatingView.setNumStars(0);

        mRatingView.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                Toast.makeText(MainActivity.this, ratingBar.getRating()+"", Toast.LENGTH_SHORT).show();
                
            }
        });

```



## **License**

```
MIT License

Copyright (c) 2017 Ashok Kumar S.


Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.

```
