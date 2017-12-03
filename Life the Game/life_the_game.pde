import processing.sound.*;

SoundFile bg_music;
SoundFile start_sound;

int winWidth = 1000, winHeight = 600;
int game_state = 0;

//universal
PFont hfont;
PFont sfont;

//states

//state 0
int t_opacity_0 = 0;

//state 1
PImage logo;
PImage bairport;
int t_opacity_1 = 0;
int t_opacity_1_2 = 0;
int t_opacity_1_3 = 0;
boolean instruct_switch = true;
boolean delay_once_1 = false;
boolean play_once = false;

//state 2;
int t_opacity_2 = 0;
int b_col_2 = 0;
boolean delay_once_2 = false;
int orig_sec_2;
int current_sec_2;

//state 3
PImage room1;
PImage couch1;
PImage toaster1;
int fader_3 = 0;

int toast_x = 840;
int toast_y = 250;
int toast_w = 200;
int toast_h = 105;
boolean toast_touch = false;
int control_toast_opacity = 0;

int couch_x = 200;
int couch_y = 50;
int couch_w = 300;
int couch_h = 147;

//state 4
int t_opacity_4 = 0;
boolean delay_once_4 = false;
int b_opacity_4 = 0;
int orig_sec_4;
int current_sec_4;

int avatar_x = 400;
int avatar_y = 259;
int avatar_w = 82;
int avatar_h = 200;
int a_speed = 20;
PImage avatar_still;
int move_num = 28;
PImage[] avatar_move = new PImage[28];
int move_state = 8;
int leftover_direction = 3;
PImage space_icon;

//conversation variables
boolean text_response = false;
int conversation_state = 0;
int conversation_opacity = 0;
int conversation_id = -1;

void setup() {
  //initializer
  size(1000, 600);
  surface.setLocation(displayWidth / 2 - (winWidth / 2), displayHeight / 2 - (winHeight / 2));
  surface.setTitle("Life The Game"); 
  smooth();
  
  hfont = createFont("Helvetica", 24);
  sfont = createFont("Helvetica Bold", 18);
  logo = loadImage("assets/logo.png");
  bairport = loadImage("assets/bairport.png");
  room1 = loadImage("assets/room1.png");
  couch1 = loadImage("assets/couch.png");
  toaster1 = loadImage("assets/toaster.png");
  avatar_still = loadImage("assets/avatar_still.png");
  space_icon = loadImage("assets/space_icon.png");
  
  for(int i =0;i < move_num;i++) {
    avatar_move[i] = loadImage("assets/avatar_" + (i + 1) + ".png");
  }
  
  bg_music = new SoundFile(this, "b_music.mp3");
  start_sound = new SoundFile(this, "start.mp3");
  bg_music.amp(0.6);
  start_sound.amp(1.0);
}

void draw() {
  rectMode(CORNER);
  noStroke();
  
  if (game_state == 0) {
    background(0, 0, 0);
    textFont(hfont);
    fill(255, 255, 255, t_opacity_0);
    text("This Game is Not Yet Rated", winWidth / 2 - 160, winHeight / 2 - 15, 320, 50);
    
    if (t_opacity_0 < 255) {
      t_opacity_0 += 1;
    } else {
      game_state = 1;
      background(255);
    }
    
  } else if(game_state == 1) {
    background(255);
    
    if(delay_once_1 == false) {
      delay(300);
      delay_once_1 = true;
    }
    
    if(t_opacity_1 < 255) {
      t_opacity_1 += 17;
    }
    
    if (t_opacity_1_2 < 100) {
     t_opacity_1_2 += 2; 
    }
    if (instruct_switch == true && t_opacity_1_3 < 255) {
      t_opacity_1_3 += 17;
      
      if(t_opacity_1_3 == 255) {
        instruct_switch = false;
      }
    } else if(instruct_switch == false && t_opacity_1_3 > 0) {
      t_opacity_1_3 -= 17;
      
      if(t_opacity_1_3 == 0) {
        instruct_switch = true;
      }
    }
    
    tint(255, t_opacity_1_2);
    image(bairport, 0, 0, 1000, 600);
    tint(255, t_opacity_1);
    image(logo, (winWidth / 2) - 300, (winHeight / 2) - 169, 600, 338);
    tint(255, 255);
    textFont(sfont);
    
    fill(0, 0, 0, t_opacity_1_3);
    text("Press Space to Start", winWidth / 2 - 90, winHeight / 2 + 200, 180, 20);
    
    if(play_once == false) {
      bg_music.loop();
      play_once = true;
    }
    
  } else if(game_state == 2) {
    background(b_col_2);
    
    if(t_opacity_2 < 255) {
      t_opacity_2 += 5;
    } else {
      if(delay_once_2 == false) {
        delay_once_2 = true;
        orig_sec_2 = second();
      } else {
        current_sec_2 = second();
      }
      
      if (current_sec_2 - orig_sec_2 >= 3) {
        if(b_col_2 < 255) {
         b_col_2 += 17;
        } else {
          game_state = 3;
        }
      }
      
    }
    
    
    textFont(hfont);
    fill(255, 255, 255, t_opacity_2);
    text("7:00 AM Time to go to the airport... Better eat some toast.", winWidth / 2 - 325, winHeight / 2 - 12, 650, 25);
    
  } else if(game_state == 3) {
    background(255);
    if(fader_3 < 255) {
      fader_3 += 17;
    }
    
    tint(255, fader_3);
    image(room1, 0, 0, 1000, 600);
    tint(255, fader_3);
    image(couch1, 200, 50, 300, 147);
    tint(255, fader_3);
    image(toaster1, toast_x, toast_y, toast_w, toast_h);
    tint(255, fader_3);
    
    move_execute();
    
    tint(255, 255);
    
    if(toast_touch == true && text_response == false) {
      if(control_toast_opacity < 180) {
        control_toast_opacity += 40;
      }
      
      fill(0, 0, 0, control_toast_opacity);
      rect(0, 0, 450, 50);
      fill(255, 255, 255, control_toast_opacity + 75);
      text("Press SPACE to boot up your toaster", 20, 30);
    } else {
      if(control_toast_opacity > 0) {
        control_toast_opacity -= 40;
      }
      
      fill(0, 0, 0, control_toast_opacity);
      rect(0, 0, 450, 50);
      fill(255, 255, 255, control_toast_opacity);
      text("Press SPACE to boot up your toaster", 20, 30);
      
    }
    
  }
  
  conversation(); 
  
}

void keyPressed() {
   if (key == CODED) {
     if(game_state == 3) {
      if(keyCode == LEFT && text_response == false) {
        leftover_direction = 0;
        
        if(hit_wall(0) == false && boundaries(0) == false) {
          avatar_x -= a_speed; 
          if(move_state < 3) {
            move_state += 1;
          } else {
            move_state = 0;
          }
        }
        
      } else if(keyCode == RIGHT && text_response == false) {
        
        leftover_direction = 1;
        
        if(hit_wall(1) == false && boundaries(1) == false) {
          avatar_x += a_speed; 
          if(move_state < 7) {
            move_state += 1;
          } else {
            move_state = 4;
          }
        }
        
      } else if(keyCode == UP && text_response == false) {
        leftover_direction = 2;
        
        if(hit_wall(2) == false && boundaries(2) == false) {
          avatar_y -= a_speed;
          if(move_state < 17) {
            move_state += 1;
          } else {
            move_state = 8;
          }
        }
        
        
        
      } else if(keyCode == DOWN && text_response == false) {
        leftover_direction = 3;
        
        if(hit_wall(3) == false && boundaries(3) == false) {
          avatar_y += a_speed;
          if(move_state < 27) {
            move_state += 1;
          } else {
            move_state = 18;
          }
        }
        
      }
     }
   } else {
     
     if (key == ' ') {
       if(game_state == 0) {
         game_state = 1; 
         background(255);
         start_sound.play();
       } else if (game_state == 1) {
         game_state = 2;
         start_sound.play();
       } else if(game_state == 2) {
         game_state = 3;
       } else if(game_state == 3 && toast_touch == true) {
         if(text_response == false) {
           conversation_id = 0;
           text_response = true;
         } else {
           conversation_state += 1;
         }
       }
       
     }
     
   }
}

boolean hit_wall(int direction) {
  boolean result = false;
  
  if(direction == 0 && (avatar_x - a_speed) < 0) {
    result = true;
  } else if(direction == 1 && (avatar_x + a_speed) > winWidth - avatar_w) {
    result = true;
  } else if(direction == 2 && (avatar_y - a_speed) < 0) {
    result = true;
  } else if(direction == 3 && (avatar_y + a_speed) > winHeight - avatar_h) {
    result = true;
  }
  
  return result;
}

boolean boundaries(int direction) {
  boolean result = false;
  
  int a_direct_x = 0;
  int a_direct_y = 0;
  
  if(direction == 0) {
    a_direct_x = -a_speed;
  } else if(direction == 1) {
    a_direct_x = a_speed;
  } else if(direction == 2) {
    a_direct_y = -a_speed;
  } else if(direction == 3) {
    a_direct_y = a_speed;
  }
  
  
  if (game_state == 3) {
    //interactive object need to be checked seperately
    if(collision(avatar_x + a_direct_x, avatar_w, avatar_y + a_direct_y, avatar_h, toast_x, toast_y, toast_w, toast_h)) {
      result = true;
    } else if(collision(avatar_x + a_direct_x, avatar_w, avatar_y + a_direct_y, avatar_h, toast_x - 40, toast_y - 40, toast_w + 80, toast_h + 80)) {
      toast_touch = true;
      return false;
    } else {
      toast_touch = false;
    }
    
    if(collision(avatar_x + a_direct_x, avatar_w, avatar_y + a_direct_y, avatar_h, couch_x, couch_y, couch_w, couch_h)) {
      result = true;
    }
    
  }
  
    
  return result;
}

boolean collision(int x1, int w1, int y1, int h1, int x2, int y2, int w2, int h2) {
  boolean result = false;
  
  if(x1 < x2 + w2 && x1 + w1 > x2 && y1 < y2 + h2 && y1 + h1 > y2) {
   result = true; 
  }
  
  return result;
}

void conversation() {
  
  if(text_response == true && conversation_opacity < 180) {
   conversation_opacity += 40;
  } else if(text_response == false && conversation_opacity > 0) {
    conversation_opacity -= 40;
  } else if(conversation_opacity == 0) {
    conversation_state = 0;
    conversation_id = -1;
  }
  
  fill(0, 0, 0, conversation_opacity);
  rect(0, winHeight - 300, winWidth, 300);
  
  tint(255, conversation_opacity);
  image(space_icon, winWidth - 170, winHeight - 55, 150, 25);
  tint(255, 255);
  
  if(game_state == 3 && conversation_id == 0) {
    fill(255, 255, 255, conversation_opacity);
    
    if(conversation_state == 0) {  
      text("What? The toaster is updating again?", 10, 350);
    } else if(conversation_state == 1) {
      text("Well I guess I better get going or I'll be late...", 10, 350);
    } else {
      text_response = false;
    }
   
  }
  
}

void move_execute() {
  if(leftover_direction == 0) {
    image(avatar_move[move_state], avatar_x, avatar_y, avatar_w, avatar_h);
  } else if(leftover_direction == 1) {
    image(avatar_move[move_state], avatar_x, avatar_y, avatar_w, avatar_h);
  } else if(leftover_direction == 2) {
    image(avatar_move[move_state], avatar_x, avatar_y, avatar_w, avatar_h);
  } else if(leftover_direction == 3) {
    image(avatar_move[move_state], avatar_x, avatar_y, avatar_w, avatar_h);
  } else {
    image(avatar_still, avatar_x, avatar_y, avatar_w, avatar_h);
  }
  
}
 
