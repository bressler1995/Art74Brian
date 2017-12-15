int canvw = 1180, canvh = 700; //window size
int current_brush = 0; //just a number for representing each brush/shape
int current_size = 10; //just a number for representing each the size of the tool

//Variable to check which color to use, black by default
int colorState = 7;

//color storage, we want to use different colors as artists!  Black by default
int r = 0;
int g = 0;
int b = 0;

//a true false variable for detecting if the use is drawing
boolean drag_active = false;
//alt key detection for color controls
boolean altkey;

//coordinates for current draw operation
//you can use the built mouseX and mouseY variables instead but I want to see if I can play with these values somehow later
int dragx = 0, dragy = 0;

int fnum = 0;


void setup() {
  //Half HD resolution with some wiggle room, maybe some people have smaller screens
  size(1180, 700);
  
  //Window Properties
  surface.setLocation(displayWidth / 2 - (canvw / 2), displayHeight / 2 - (canvh / 2));
  surface.setTitle("Cave Illustrator"); 
  
  smooth();
  //we will call background here, we don't want our hard work resetting itself.  But try moving this to the draw loop
  //you will notice something interesting
  background(255, 255, 255);
 
}
 
void draw() {
  //this just checks the windows size, it's good to store it since we have it set to resizable
  noStroke();
  
    if (keyPressed) {
      clear_canvas();
    }
 
  //this part recieves the mouse data real time since we are in the draw loop
  if(drag_active == true) {
    //sets color to color rgb color variables
    fill(r, g, b);
    
    //checks current brush, basically circle or square
    if (current_brush == 0) {
      ellipse(dragx, dragy, current_size, current_size);
      
    } else if(current_brush == 1) {
      rect(dragx, dragy, current_size, current_size);
    }
   
  }
  
  //Good news!  You actually don't need this part, I just wanted to visually represent the tools and which ones are selected
  //if you want to try using my tool module, scroll down to the tool_module function and take a peek at the code
  tool_module();
}

void clear_canvas() {
  if(key == 'c' || key == 'C') {
    background(255);
  }
}

void save_canvas() {
  
  PImage croppedScreen = get(0,70,1180,630);
  croppedScreen.save("images/brres-" + nf(fnum,4) +".jpg");
  fnum++;

}

void mouseDragged() {
  //we want to be able to tell the draw loop that our mouse is pressed down and where to draw new shapes
  dragx = mouseX;
  dragy = mouseY;
  drag_active = true;
}

void mouseReleased() {
  //tells the program it is no longer drawing and resets the draw coordinates for elegance
  drag_active = false;
}

void keyPressed() {
  //the whole program will use number keys just to keep it simple
  println("typed " + keyCode);
  
  if (key == '1' && altkey == false) {
    current_brush = 0;
  } else if(key == '2' && altkey == false) {
    current_brush = 1;
  } else if(key == '3' && altkey == false) {
    current_size = 10;
  } else if(key == '4' && altkey == false) {
    current_size = 20;
  } else if(key == '5' && altkey == false) {
    current_size = 40;
  } else if(key == '6' && altkey == false) {
    current_size = 60;
  }
  
  if (key == CODED) {
    if(keyCode == CONTROL) {
      altkey = true;
    }
  }
  
      //you only need key='#' but I noticed that some machines had trouble mapping to the same keys (particularly on mac as I am using windows)
      if ((key == '1' || keyCode == 49) && altkey == true) {
        colorState = 0;
        r = 255;
        g = 0;
        b = 0;
      } else if((key == '2' || keyCode == 50) && altkey == true) {
        colorState = 1;
        r = 255;
        g = 127;
        b = 0;
      } else if((key == '3' || keyCode == 51) && altkey == true) {
        colorState = 2;
        r = 255;
        g = 255;
        b = 0;
      } else if((key == '4' || keyCode == 52) && altkey == true) {
        colorState = 3;
        r = 0;
        g = 255;
        b = 0;
      } else if((key == '5' || keyCode == 53) && altkey == true) {
        colorState = 4;
        r = 0;
        g = 0;
        b = 255;
      } else if((key == '6' || keyCode == 54) && altkey == true) {
        colorState = 5;
        r = 150;
        g = 0;
        b = 255;
      } else if((key == '7' || keyCode == 55) && altkey == true) {
        colorState = 6;
        r = 255;
        g = 255;
        b = 255;
      } else if((key == '8' || keyCode == 56) && altkey == true) {
        colorState = 7;
        r = 0;
        g = 0;
        b = 0;
      } else if((key == 's' || keyCode == 83) && altkey == true) {
        System.out.println("Attempting to Save...");
        save_canvas();
      }
}

void keyReleased() {
  if (key == CODED) {
    if (keyCode == CONTROL) {
      altkey = false;
    }
  }
} 

void tool_module() {
  //remove the tool_module function call from the draw loop if you don't want this
  //you'll notice the code here is not too bad, it's just fill colors, text, squares, and outlines, nested in if statements to check which tools have been chosen
  
  fill(66);
  rect(0, 0, canvw, 70);
  
  fill(255);
  textSize(24);
  text("Brushes", 10, 42);
  text("Size", 220, 42);
  text("Colors", 490, 42);
  
  //these are tool panels, I just wanted to allow for the tool to highlight so the program is more comprehensive
  if (current_brush == 0) {
    fill(91, 177, 201);
  } else {
    fill(99);
  }
  
  rect(110, 15, 40, 40);
  
  if (current_brush == 1) {
    fill(91, 177, 201);
  } else {
    fill(99);
  }
  
  rect(160, 15, 40, 40);
  
  //sizes
  if (current_size == 10) {
    fill(91, 177, 201);
  } else {
    fill(99);
  }
  
  rect(280, 15, 40, 40);
  
  if (current_size == 20) {
    fill(91, 177, 201);
  } else {
    fill(99);
  }
  
  rect(330, 15, 40, 40);
  
  if (current_size == 40) {
    fill(91, 177, 201);
  } else {
    fill(99);
  }
  
  rect(380, 15, 40, 40);
  
  if (current_size == 60) {
    fill(91, 177, 201);
  } else {
    fill(99);
  }
  
  rect(430, 15, 40, 40);
  
  //COLOR TOOLS
  strokeWeight(3);
  
  if(colorState == 0) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  
  fill(255,0,0);
  rect(575, 15, 40, 40);
  
  if(colorState == 1) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(255,127,0);
  rect(625, 15, 40, 40);
  
  if(colorState == 2) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(255,255,0);
  rect(675, 15, 40, 40);
  
  if(colorState == 3) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(0,255,0);
  rect(725, 15, 40, 40);
  
  if(colorState == 4) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(0,0,255);
  rect(775, 15, 40, 40);
  
  if(colorState == 5) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(150,0,255);
  rect(825, 15, 40, 40);
  
  if(colorState == 6) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(255,255,255);
  rect(875, 15, 40, 40);
  
  if(colorState == 7) {
    stroke(91, 177, 201);
  } else {
    noStroke();
  }
  
  fill(0,0,0);
  rect(925, 15, 40, 40);
  
  noStroke();
  
  //icons
  fill(255);
  ellipse(130, 35, 20, 20);
  rect(170, 25, 20, 20);
  
  ellipse(300, 35, 5, 5);
  ellipse(350, 35, 10, 10);
  ellipse(400, 35, 15, 15);
  ellipse(450, 35, 20, 20);
}
