# **SquareRatingView**

We have seen RatingBar and it's support component AppCompatRatingBar but the problem is its difficult to customise. This library helps in customising SquareRatingView with number Rate items and so on. 

[![Android Arsenal]( https://img.shields.io/badge/Android%20Arsenal-SquareRatingView-green.svg?style=flat )]( https://android-arsenal.com/details/1/6420 )

![Library screen](https://github.com/ashokslsk/SquareRatingView/blob/master/screens/Animated.gif)


# Installation

```gradle

 
 //Add it in your root build.gradle at the end of repositories:

allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
}

dependencies {
	        compile 'com.github.ashokslsk:SquareRatingView:1.1'
	}


// Latest update with support to setting drawables as selected and unslected states.

dependencies {
	        compile 'com.github.ashokslsk:SquareRatingView:1.2'
	}
```

# XML VIEW

```xml
 
<com.ashokslsk.androidabcd.squarerating.SquareRatingView
        android:id="@+id/square"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:setNumSquare="8"
        app:setRating="0"
        app:setStepSize="0.5" />

```
```
 <com.ashokslsk.androidabcd.squarerating.SquareRatingView
        android:id="@+id/square"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        app:setNumSquare="8"
        app:setRating="0"
        app:setSelectedResource="@mipmap/ic_launcher"
        app:setUnSelectedResource="@mipmap/ic_launcher_round"
        app:setStepSize="0.5" />

```

Use the following values for customising the rating tiles and stepsizes. 

        app:setNumSquare="8"
        app:setRating="0"
        app:setStepSize="0.5"

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
