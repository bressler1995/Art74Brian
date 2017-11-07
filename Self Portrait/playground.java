int canvw = 1000, canvh = 1000;

int[][] haircords = new int[302][2];
int[][] chincords = new int[12][2];
int[][] eyecords = new int[5][2];
int[][] facecords = new int[16][2];

void setup() {
  //set size and center window
  size(1000, 1000);
  surface.setLocation(displayWidth / 2 - (canvw / 2), displayHeight / 2 - (canvh / 2));
  surface.setTitle("Self Portrait"); 
  smooth();
   
   //call functions that assign coordinates
   get_hair();
   get_chin();
   get_eyes();
   get_face();
}

void draw() {
    background(255);
    noStroke();
    
    //calls function which draws shapes to screen
    draw_parts();
}

void draw_parts() {
  
  float r = random(0, 150);
  int g = 0;
  int b = 0;
  
  fill(r, g, b);
  
  //loops go through all the coordinates in each area
  
  for(int i = 0; i < haircords.length; i++) {
    if (mouseX <= haircords[i][0] + 70 && mouseX >= haircords[i][0] - 70 && mouseY <= haircords[i][1] + 70 && mouseY >= haircords[i][1] - 70) {
      fill(random(255), random(255), random(255));
      ellipse(haircords[i][0], haircords[i][1], random(40, 60), random(40, 60)); 
    } else {
      fill(r, g, b);
      ellipse(haircords[i][0], haircords[i][1], random(20, 40), random(20, 40)); 
    }
    
    //ellipse(haircords[i][0], haircords[i][1], random(20, 40), random(20, 40)); 
  }
  
  fill(r, g, b);
  
  for(int i = 0; i < chincords.length; i++) {
    if (mouseX <= chincords[i][0] + 70 && mouseX >= chincords[i][0] - 70 && mouseY <= chincords[i][1] + 70 && mouseY >= chincords[i][1] - 70) {
      fill(random(255), random(255), random(255));
      ellipse(chincords[i][0], chincords[i][1] - 20, random(25, 50), random(25, 50));
    } else {
      fill(r, g, b);
      ellipse(chincords[i][0], chincords[i][1] - 20, random(15, 30), random(15, 30));
    }
    
    //ellipse(chincords[i][0], chincords[i][1] - 20, random(15, 30), random(15, 30));
  }
  
  fill(r, g, b);
  
  for (int i = 0; i < eyecords.length; i++) {
    //eyebrow left
    float brow1w = random(40, 70);
    float brow2w = random(40, 70);
    float brow1h = random(5, 10);
    float brow2h = random(5, 10);
    
    float brow1x = random(eyecords[i][0] + 20, eyecords[i][0] + 40);
    float brow2x = (random(eyecords[i][0] + 20, eyecords[i][0] + 40)) + 220;
    
    if(mouseX >= brow1x - 20 && mouseX <= brow1x + brow1w + 20 && mouseY >= eyecords[i][1] - 20 && mouseY <= eyecords[i][1] + brow1h + 20) {
      fill(random(255), random(255), random(255));
      rect(brow1x, eyecords[i][1], random(brow1w, brow1w + 20), random(brow1h, brow1h + 20));
    } else {
      fill(r, g, b);
      rect(brow1x, eyecords[i][1], brow1w, brow1h);
    }
    
    fill(r, g, b);
    
    //eyebrow right
    if(mouseX >= brow2x - 20 && mouseX <= brow2x + brow2w + 20 && mouseY >= eyecords[i][1] - 20 && mouseY <= eyecords[i][1] + brow2h + 20) {
      fill(random(255), random(255), random(255));
      rect(brow2x, eyecords[i][1], random(brow2w, brow2w + 20), random(brow2h, brow2h + 20));
    } else {
      fill(r, g, b);
      rect(brow2x, eyecords[i][1], brow2w, brow2h);
    }
    
    fill(r, g, b);
  }
  
  fill(r, g, b);
  
  if (mouseX <= eyecords[3][0] + 20 + 70 && mouseX >= eyecords[3][0] + 20 - 70 && mouseY <= eyecords[2][1] + 50 + 70 && mouseY >= eyecords[3][1] + 50 - 70) {
    fill(random(255), random(255), random(255));
    ellipse(eyecords[3][0] + 20, eyecords[2][1] + 50, random(30, 50), random(30, 50));
  } else {
    fill(r, g, b);
    ellipse(eyecords[3][0] + 20, eyecords[2][1] + 50, random(20, 40), random(20, 40));
  }
  
  fill(r, g, b);
  
  
  if (mouseX <= (eyecords[3][0] + 20 + 70) + 220 && mouseX >= (eyecords[3][0] + 20 - 70) + 220 && mouseY <= eyecords[2][1] + 50 + 70 && mouseY >= eyecords[3][1] + 50 - 70) {
    fill(random(255), random(255), random(255));
    ellipse((eyecords[3][0] + 20) + 220, eyecords[2][1] + 50, random(30, 50), random(30, 50));
  } else {
    fill(r, g, b);
    ellipse((eyecords[3][0] + 20) + 220, eyecords[2][1] + 50, random(20, 40), random(20, 40));
  }
  
  fill(r, g, b);
  
  for(int i = 0; i < facecords.length; i++) {
    if (mouseX <= facecords[i][0] + 70 && mouseX >= facecords[i][0] - 70 && mouseY <= facecords[i][1] + 70 && mouseY >= facecords[i][1] - 70) {
      fill(random(255), random(255), random(255));
      ellipse(facecords[i][0], facecords[i][1], random(30, 50), random(30, 50));
    } else {
      fill(r, g, b);
      ellipse(facecords[i][0], facecords[i][1], random(10, 20), random(10, 20));
    }
    
    //ellipse(facecords[i][0], facecords[i][1], random(10, 20), random(10, 20));
  }
  
  
}

void get_face() {
  facecords[0][0] = 350;
  facecords[0][1] = 320;
  
  facecords[1][0] = 350;
  facecords[1][1] = 350;
  
  facecords[2][0] = 330;
  facecords[2][1] = 380;
  
  facecords[3][0] = 310;
  facecords[3][1] = 400;
  
  facecords[4][0] = 310;
  facecords[4][1] = 420;
  
  facecords[5][0] = 330;
  facecords[5][1] = 420;
  
  facecords[6][0] = 350;
  facecords[6][1] = 420;
  
  //mouth
  
  facecords[7][0] = 280;
  facecords[7][1] = 510;
  
  facecords[8][0] = 300;
  facecords[8][1] = 500;
  
  facecords[9][0] = 320;
  facecords[9][1] = 500;
  
  facecords[10][0] = 340;
  facecords[10][1] = 500;
  
  facecords[11][0] = 360;
  facecords[11][1] = 500;
  
  facecords[12][0] = 380;
  facecords[12][1] = 500;
  
  facecords[13][0] = 400;
  facecords[13][1] = 500;
  
  facecords[14][0] = 420;
  facecords[14][1] = 500;
  
  facecords[15][0] = 440;
  facecords[15][1] = 505;
  
}

void get_eyes() {
  
  eyecords[0][0] = 150;
  eyecords[0][1] = 270;
  
  eyecords[1][0] = 200;
  eyecords[1][1] = 260;
  
  eyecords[2][0] = 200;
  eyecords[2][1] = 250;
  
  eyecords[3][0] = 240;
  eyecords[3][1] = 260;
  
  eyecords[4][0] = 260;
  eyecords[4][1] = 270;
  
  
  
}

void get_chin() {
  chincords[0][0] = 220;
  chincords[0][1] = 580;
  
  chincords[1][0] = 250;
  chincords[1][1] = 610;
  
  chincords[2][0] = 280;
  chincords[2][1] = 630;
  
  chincords[3][0] = 310;
  chincords[3][1] = 630;
  
  chincords[4][0] = 340;
  chincords[4][1] = 630;
  
  chincords[5][0] = 340;
  chincords[5][1] = 630;
  
  chincords[6][0] = 370;
  chincords[6][1] = 630;
  
  chincords[7][0] = 400;
  chincords[7][1] = 630;
  
  chincords[8][0] = 430;
  chincords[8][1] = 630;
  
  chincords[9][0] = 470;
  chincords[9][1] = 630;
  
   chincords[10][0] = 500;
  chincords[10][1] = 630;
  
  chincords[11][0] = 530;
  chincords[11][1] = 600;
}

void get_hair() {
  //hair outline
   haircords[0][0] = 120;
   haircords[0][1] = 100;
   
   haircords[1][0] = 100;
   haircords[1][1] = 120;
   
   haircords[2][0] = 90;
   haircords[2][1] = 140;
   
   haircords[3][0] = 70;
   haircords[3][1] = 160;
   
   haircords[4][0] = 70;
   haircords[4][1] = 190;
   
   haircords[5][0] = 70;
   haircords[5][1] = 220;
   
   haircords[6][0] = 60;
   haircords[6][1] = 250;
   
   haircords[7][0] = 60;
   haircords[7][1] = 280;
   
   haircords[8][0] = 60;
   haircords[8][1] = 310;
   
   haircords[9][0] = 60;
   haircords[9][1] = 340;
   
   haircords[10][0] = 55;
   haircords[10][1] = 370;
   
   haircords[11][0] = 55;
   haircords[11][1] = 400;
   
   haircords[12][0] = 50;
   haircords[12][1] = 430;
   
   haircords[13][0] = 50;
   haircords[13][1] = 460;
   
   haircords[14][0] = 60;
   haircords[14][1] = 490;
   
   haircords[15][0] = 50;
   haircords[15][1] = 520;
   
   haircords[16][0] = 40;
   haircords[16][1] = 550;
   
   haircords[17][0] = 40;
   haircords[17][1] = 580;
   
   haircords[18][0] = 30;
   haircords[18][1] = 610;
   
   haircords[18][0] = 30;
   haircords[18][1] = 610;
   
   haircords[19][0] = 20;
   haircords[19][1] = 640;
   
   haircords[20][0] = 40;
   haircords[20][1] = 670;
   
   haircords[21][0] = 50;
   haircords[21][1] = 700;
   
   haircords[22][0] = 65;
   haircords[22][1] = 720;
   
   haircords[23][0] = 90;
   haircords[23][1] = 720;
   
   haircords[24][0] = 120;
   haircords[24][1] = 700;
   
   haircords[25][0] = 150;
   haircords[25][1] = 710;
   
   haircords[26][0] = 180;
   haircords[26][1] = 710;
   
   haircords[27][0] = 210;
   haircords[27][1] = 690;
   
   haircords[28][0] = 220;
   haircords[28][1] = 660;
   
   haircords[29][0] = 210;
   haircords[29][1] = 640;
   
   haircords[30][0] = 190;
   haircords[30][1] = 620;
   
   haircords[31][0] = 190;
   haircords[31][1] = 590;
   
   haircords[32][0] = 190;
   haircords[32][1] = 560;
   
   haircords[33][0] = 170;
   haircords[33][1] = 530;
   
   haircords[34][0] = 160;
   haircords[34][1] = 500;
   
   haircords[35][0] = 160;
   haircords[35][1] = 470;
   
   haircords[36][0] = 160;
   haircords[36][1] = 440;
   
   haircords[37][0] = 160;
   haircords[37][1] = 410;
   
   haircords[38][0] = 160;
   haircords[38][1] = 380;
   
   haircords[39][0] = 160;
   haircords[39][1] = 350;
   
   haircords[40][0] = 160;
   haircords[40][1] = 320;
   
   haircords[41][0] = 160;
   haircords[41][1] = 290;
   
   haircords[42][0] = 160;
   haircords[42][1] = 260;
   
   haircords[43][0] = 170;
   haircords[43][1] = 230;
   
   haircords[44][0] = 170;
   haircords[44][1] = 200;
   
   haircords[45][0] = 190;
   haircords[45][1] = 170;
   
   haircords[46][0] = 220;
   haircords[46][1] = 140;
   
   haircords[47][0] = 250;
   haircords[47][1] = 110;
   
   haircords[48][0] = 280;
   haircords[48][1] = 140;
   
   haircords[49][0] = 310;
   haircords[49][1] = 140;
   
   haircords[50][0] = 330;
   haircords[50][1] = 120;
   
   haircords[51][0] = 350;
   haircords[51][1] = 110;
   
   haircords[52][0] = 380;
   haircords[52][1] = 110;
   
   haircords[53][0] = 420;
   haircords[53][1] = 110;
   
   haircords[54][0] = 450;
   haircords[54][1] = 110;
   
   haircords[55][0] = 480;
   haircords[55][1] = 140;
   
   haircords[56][0] = 510;
   haircords[56][1] = 170;
   
   haircords[57][0] = 540;
   haircords[57][1] = 200;
   
   haircords[58][0] = 570;
   haircords[58][1] = 230;
   
   haircords[59][0] = 600;
   haircords[59][1] = 260;
   
   haircords[60][0] = 600;
   haircords[60][1] = 290;
   
   haircords[61][0] = 600;
   haircords[61][1] = 320;
   
   haircords[62][0] = 630;
   haircords[62][1] = 350;
   
   haircords[63][0] = 630;
   haircords[63][1] = 380;
   
   haircords[64][0] = 630;
   haircords[64][1] = 420;
   
   haircords[65][0] = 630;
   haircords[65][1] = 450;
   
   haircords[66][0] = 630;
   haircords[66][1] = 480;
   
   haircords[67][0] = 630;
   haircords[67][1] = 510;
   
   haircords[68][0] = 630;
   haircords[68][1] = 540;
   
   haircords[69][0] = 600;
   haircords[69][1] = 570;
   
   haircords[70][0] = 570;
   haircords[70][1] = 600;
   
   haircords[71][0] = 550;
   haircords[71][1] = 630;
   
   haircords[72][0] = 550;
   haircords[72][1] = 660;
   
   haircords[73][0] = 550;
   haircords[73][1] = 690;
   
   haircords[74][0] = 580;
   haircords[74][1] = 720;
   
   haircords[75][0] = 620;
   haircords[75][1] = 720;
   
   haircords[76][0] = 650;
   haircords[76][1] = 720;
   
   haircords[77][0] = 680;
   haircords[77][1] = 720;
   
   haircords[78][0] = 710;
   haircords[78][1] = 710;
   
   haircords[79][0] = 740;
   haircords[79][1] = 680;
   
   haircords[80][0] = 740;
   haircords[80][1] = 650;
   
   haircords[81][0] = 770;
   haircords[81][1] = 630;
   
   haircords[82][0] = 800;
   haircords[82][1] = 620;
   
   haircords[83][0] = 800;
   haircords[83][1] = 590;
   
   haircords[84][0] = 800;
   haircords[84][1] = 560;
   
   haircords[85][0] = 800;
   haircords[85][1] = 530;
   
   haircords[86][0] = 770;
   haircords[86][1] = 500;
   
   haircords[87][0] = 770;
   haircords[87][1] = 470;
   
   haircords[88][0] = 770;
   haircords[88][1] = 440;
   
   haircords[89][0] = 770;
   haircords[89][1] = 410;
   
   haircords[90][0] = 770;
   haircords[90][1] = 380;
   
   haircords[91][0] = 740;
   haircords[91][1] = 350;
   
   haircords[92][0] = 710;
   haircords[92][1] = 320;
   
   haircords[93][0] = 710;
   haircords[93][1] = 290;
   
   haircords[94][0] = 680;
   haircords[94][1] = 260;
   
   haircords[95][0] = 680;
   haircords[95][1] = 230;
   
   haircords[96][0] = 650;
   haircords[96][1] = 200;
   
   haircords[97][0] = 620;
   haircords[97][1] = 180;
   
   haircords[98][0] = 600;
   haircords[98][1] = 150;
   
   haircords[99][0] = 570;
   haircords[99][1] = 120;
   
   haircords[100][0] = 540;
   haircords[100][1] = 90;
   
   haircords[101][0] = 510;
   haircords[101][1] = 60;
   
   haircords[102][0] = 475;
   haircords[102][1] = 60;
   
   haircords[103][0] = 445;
   haircords[103][1] = 55;
   
   haircords[104][0] = 415;
   haircords[104][1] = 55;
   
   haircords[105][0] = 395;
   haircords[105][1] = 75;
   
   haircords[106][0] = 365;
   haircords[106][1] = 55;
   
   haircords[107][0] = 335;
   haircords[107][1] = 55;
   
   haircords[108][0] = 305;
   haircords[108][1] = 55;
   
   haircords[109][0] = 275;
   haircords[109][1] = 55;
   
   haircords[110][0] = 245;
   haircords[110][1] = 60;
   
   haircords[111][0] = 215;
   haircords[111][1] = 65;
   
   haircords[112][0] = 185;
   haircords[112][1] = 70;
   
   haircords[113][0] = 155;
   haircords[113][1] = 75;
   
   //fill hair
   
   haircords[114][0] = 100;
   haircords[114][1] = 670;
   
   haircords[115][0] = 70;
   haircords[115][1] = 670;
   
   haircords[116][0] = 130;
   haircords[116][1] = 670;
   
   haircords[117][0] = 160;
   haircords[117][1] = 670;
   
   haircords[118][0] = 190;
   haircords[118][1] = 670;
   
   haircords[119][0] = 70;
   haircords[119][1] = 690;
   
   haircords[120][0] = 100;
   haircords[120][1] = 690;
   
   haircords[121][0] = 130;
   haircords[121][1] = 690;
   
   haircords[122][0] = 160;
   haircords[122][1] = 690;
   
   haircords[123][0] = 190;
   haircords[123][1] = 690;
   
   haircords[124][0] = 50;
   haircords[124][1] = 645;
   
   haircords[125][0] = 80;
   haircords[125][1] = 645;
   
   haircords[126][0] = 110;
   haircords[126][1] = 645;
   
   haircords[127][0] = 140;
   haircords[127][1] = 645;
   
   haircords[128][0] = 170;
   haircords[128][1] = 645;
   
   haircords[129][0] = 200;
   haircords[129][1] = 645;
   
   haircords[129][0] = 60;
   haircords[129][1] = 615;
   
   haircords[130][0] = 90;
   haircords[130][1] = 615;
   
   haircords[131][0] = 120;
   haircords[131][1] = 615;
   
   haircords[132][0] = 150;
   haircords[132][1] = 615;
   
   haircords[133][0] = 180;
   haircords[133][1] = 615;
   
   haircords[134][0] = 70;
   haircords[134][1] = 585;
   
   haircords[135][0] = 100;
   haircords[135][1] = 585;
   
   haircords[136][0] = 130;
   haircords[136][1] = 585;
   
   haircords[137][0] = 160;
   haircords[137][1] = 585;
   
   haircords[138][0] = 70;
   haircords[138][1] = 555;
   
   haircords[139][0] = 100;
   haircords[139][1] = 555;
   
   haircords[140][0] = 130;
   haircords[140][1] = 555;
   
   haircords[141][0] = 160;
   haircords[141][1] = 555;
   
   haircords[142][0] = 80;
   haircords[142][1] = 525;
   
   haircords[143][0] = 110;
   haircords[143][1] = 525;
   
   haircords[144][0] = 140;
   haircords[144][1] = 525;
   
   haircords[145][0] = 170;
   haircords[145][1] = 525;
   
   haircords[146][0] = 90;
   haircords[146][1] = 495;
   
   haircords[147][0] = 120;
   haircords[147][1] = 495;
   
   haircords[148][0] = 150;
   haircords[148][1] = 495;
   
   haircords[149][0] = 80;
   haircords[149][1] = 465;
   
   haircords[150][0] = 110;
   haircords[150][1] = 465;
   
   haircords[151][0] = 140;
   haircords[151][1] = 465;
   
   haircords[152][0] = 80;
   haircords[152][1] = 435;
   
   haircords[153][0] = 110;
   haircords[153][1] = 435;
   
   haircords[154][0] = 140;
   haircords[154][1] = 435;
   
   haircords[155][0] = 80;
   haircords[155][1] = 405;
   
   haircords[156][0] = 110;
   haircords[156][1] = 405;
   
   haircords[157][0] = 140;
   haircords[157][1] = 405;
   
   haircords[158][0] = 85;
   haircords[158][1] = 375;
   
   haircords[159][0] = 115;
   haircords[159][1] = 375;
   
   haircords[160][0] = 140;
   haircords[160][1] = 375;
   
   haircords[161][0] = 90;
   haircords[161][1] = 345;
   
   haircords[162][0] = 120;
   haircords[162][1] = 345;
   
   haircords[163][0] = 150;
   haircords[163][1] = 345;
   
   haircords[164][0] = 90;
   haircords[164][1] = 315;
   
   haircords[165][0] = 120;
   haircords[165][1] = 315;
   
   haircords[166][0] = 150;
   haircords[166][1] = 315;
   
   haircords[167][0] = 90;
   haircords[167][1] = 285;
   
   haircords[168][0] = 120;
   haircords[168][1] = 285;
   
   haircords[169][0] = 150;
   haircords[169][1] = 285;
   
   haircords[170][0] = 90;
   haircords[170][1] = 255;
   
   haircords[171][0] = 120;
   haircords[171][1] = 255;
   
   haircords[172][0] = 150;
   haircords[172][1] = 255;
   
   haircords[173][0] = 100;
   haircords[173][1] = 225;
   
   haircords[174][0] = 130;
   haircords[174][1] = 225;
   
   haircords[175][0] = 150;
   haircords[175][1] = 225;
   
   haircords[176][0] = 100;
   haircords[176][1] = 195;
   
   haircords[177][0] = 130;
   haircords[177][1] = 195;
   
   haircords[178][0] = 160;
   haircords[178][1] = 195;
   
   haircords[179][0] = 100;
   haircords[179][1] = 165;
   
   haircords[180][0] = 130;
   haircords[180][1] = 165;
   
   haircords[181][0] = 160;
   haircords[181][1] = 165;
   
   haircords[182][0] = 120;
   haircords[182][1] = 135;
   
   haircords[183][0] = 150;
   haircords[183][1] = 135;
   
   haircords[184][0] = 180;
   haircords[184][1] = 135;
   
   haircords[185][0] = 210;
   haircords[185][1] = 135;
   
   haircords[186][0] = 140;
   haircords[186][1] = 115;
   
   haircords[187][0] = 170;
   haircords[187][1] = 115;
   
   haircords[188][0] = 200;
   haircords[188][1] = 115;
   
   haircords[189][0] = 230;
   haircords[189][1] = 115;
   
   haircords[190][0] = 120;
   haircords[190][1] = 95;
   
   haircords[191][0] = 150;
   haircords[191][1] = 95;
   
   haircords[192][0] = 180;
   haircords[192][1] = 95;
   
   haircords[193][0] = 210;
   haircords[193][1] = 95;
   
   haircords[194][0] = 240;
   haircords[194][1] = 95;
   
   haircords[195][0] = 270;
   haircords[195][1] = 95;
   
   haircords[196][0] = 200;
   haircords[196][1] = 75;
   
   haircords[197][0] = 230;
   haircords[197][1] = 75;
   
   haircords[198][0] = 260;
   haircords[198][1] = 75;
   
   haircords[199][0] = 250;
   haircords[199][1] = 150;
   
   haircords[200][0] = 250;
   haircords[200][1] = 130;
   
   haircords[201][0] = 260;
   haircords[201][1] = 120;
   
   haircords[202][0] = 280;
   haircords[202][1] = 120;
   
   haircords[203][0] = 280;
   haircords[203][1] = 70;
   
   haircords[204][0] = 300;
   haircords[204][1] = 75;
   
   haircords[205][0] = 330;
   haircords[205][1] = 75;
   
   haircords[206][0] = 360;
   haircords[206][1] = 75;
   
   haircords[207][0] = 300;
   haircords[207][1] = 85;
   
   haircords[208][0] = 330;
   haircords[208][1] = 85;
   
   haircords[209][0] = 360;
   haircords[209][1] = 85;
   
   haircords[210][0] = 390;
   haircords[210][1] = 85;
   
   haircords[211][0] = 320;
   haircords[211][1] = 95;
   
   haircords[212][0] = 300;
   haircords[212][1] = 120;
   
   haircords[213][0] = 430;
   haircords[213][1] = 85;
   
   haircords[214][0] = 455;
   haircords[214][1] = 85;
   
   haircords[215][0] = 485;
   haircords[215][1] = 85;
   
   haircords[216][0] = 515;
   haircords[216][1] = 85;
   
   haircords[217][0] = 490;
   haircords[217][1] = 110;
   
   haircords[218][0] = 520;
   haircords[218][1] = 110;
   
   haircords[219][0] = 540;
   haircords[219][1] = 110;
   
   haircords[220][0] = 555;
   haircords[220][1] = 140;
   
   haircords[221][0] = 525;
   haircords[221][1] = 140;
   
   haircords[222][0] = 505;
   haircords[222][1] = 140;
   
   haircords[223][0] = 535;
   haircords[223][1] = 160;
  
  
  haircords[224][0] = 560;
  haircords[224][1] = 160;
  
  haircords[225][0] = 580;
  haircords[225][1] = 160;
  
  haircords[226][0] = 590;
  haircords[226][1] = 185;
  
  haircords[227][0] = 560;
  haircords[227][1] = 185;
  
  haircords[228][0] = 585;
  haircords[228][1] = 215;
  
  haircords[229][0] = 615;
  haircords[229][1] = 215;
  
  haircords[230][0] = 645;
  haircords[230][1] = 215;
  
  haircords[231][0] = 645;
  haircords[231][1] = 245;
  
  haircords[232][0] = 615;
  haircords[232][1] = 245;
  
  haircords[233][0] = 630;
  haircords[233][1] = 275;
  
  haircords[234][0] = 660;
  haircords[234][1] = 275;
  
  haircords[235][0] = 680;
  haircords[235][1] = 305;
  
  haircords[236][0] = 650;
  haircords[236][1] = 305;
  
  haircords[237][0] = 620;
  haircords[237][1] = 305;
  
  haircords[238][0] = 660;
  haircords[238][1] = 335;
  
  haircords[239][0] = 690;
  haircords[239][1] = 335;
  
  haircords[240][0] = 710;
  haircords[240][1] = 360;
  
  haircords[241][0] = 680;
  haircords[241][1] = 360;
  
  haircords[242][0] = 650;
  haircords[242][1] = 360;
  
  haircords[243][0] = 650;
  haircords[243][1] = 390;
  
  haircords[244][0] = 680;
  haircords[244][1] = 390;
  
  haircords[245][0] = 710;
  haircords[245][1] = 390;
  
  haircords[246][0] = 740;
  haircords[246][1] = 390;
  
  haircords[247][0] = 740;
  haircords[247][1] = 420;
  
  haircords[248][0] = 710;
  haircords[248][1] = 420;
  
  haircords[249][0] = 680;
  haircords[249][1] = 420;
  
  haircords[250][0] = 650;
  haircords[250][1] = 420;
  
  haircords[251][0] = 655;
  haircords[251][1] = 450;
  
  haircords[252][0] = 685;
  haircords[252][1] = 450;
  
  haircords[253][0] = 715;
  haircords[253][1] = 450;

  haircords[254][0] = 745;
  haircords[254][1] = 450;
  
  haircords[255][0] = 745;
  haircords[255][1] = 480;
  
  haircords[256][0] = 715;
  haircords[256][1] = 480;
  
  haircords[257][0] = 685;
  haircords[257][1] = 480;
  
  haircords[258][0] = 655;
  haircords[258][1] = 480;
  
  haircords[259][0] = 655;
  haircords[259][1] = 510;
  
  haircords[260][0] = 685;
  haircords[260][1] = 510;
  
  haircords[261][0] = 715;
  haircords[261][1] = 510;
  
  haircords[262][0] = 745;
  haircords[262][1] = 510;
  
  haircords[263][0] = 765;
  haircords[263][1] = 515;
  
  haircords[264][0] = 765;
  haircords[264][1] = 545;
  
  haircords[265][0] = 735;
  haircords[265][1] = 540;
  
  haircords[266][0] = 705;
  haircords[266][1] = 540;
  
  haircords[267][0] = 775;
  haircords[267][1] = 540;
  
  haircords[268][0] = 735;
  haircords[268][1] = 540;
  
  haircords[269][0] = 675;
  haircords[269][1] = 540;
  
  haircords[270][0] = 715;
  haircords[270][1] = 540;
  
  haircords[271][0] = 650;
  haircords[271][1] = 540;
  
  haircords[272][0] = 630;
  haircords[272][1] = 570;
  
  haircords[273][0] = 660;
  haircords[273][1] = 570;
  
  haircords[274][0] = 690;
  haircords[274][1] = 570;
  
  haircords[275][0] = 720;
  haircords[275][1] = 570;
  
  haircords[276][0] = 750;
  haircords[276][1] = 570;
  
  haircords[277][0] = 780;
  haircords[277][1] = 570;
  
  haircords[278][0] = 775;
  haircords[278][1] = 595;
  
  haircords[279][0] = 745;
  haircords[279][1] = 595;
  
  haircords[280][0] = 745;
  haircords[280][1] = 615;
  
  haircords[281][0] = 715;
  haircords[281][1] = 600;
  
  haircords[282][0] = 685;
  haircords[282][1] = 600;
  
  haircords[283][0] = 655;
  haircords[283][1] = 600;
  
  haircords[284][0] = 625;
  haircords[284][1] = 600;
  
  haircords[285][0] = 595;
  haircords[285][1] = 600;
  
  haircords[285][0] = 575;
  haircords[285][1] = 625;
  
  haircords[286][0] = 595;
  haircords[286][1] = 600;
  
  haircords[287][0] = 605;
  haircords[287][1] = 625;
  
  haircords[288][0] = 635;
  haircords[288][1] = 625;
  
  haircords[289][0] = 665;
  haircords[289][1] = 625;
  
  haircords[290][0] = 695;
  haircords[290][1] = 625;
  
  haircords[291][0] = 715;
  haircords[291][1] = 625;
  
  haircords[292][0] = 705;
  haircords[292][1] = 655;
  
  haircords[293][0] = 675;
  haircords[293][1] = 655;
  
  haircords[294][0] = 645;
  haircords[294][1] = 655;
  
  haircords[295][0] = 615;
  haircords[295][1] = 655;
  
  haircords[296][0] = 585;
  haircords[296][1] = 655;
  
  haircords[297][0] = 585;
  haircords[297][1] = 685;
  
  haircords[298][0] = 615;
  haircords[298][1] = 685;
  
  haircords[299][0] = 645;
  haircords[299][1] = 685;
  
  haircords[300][0] = 675;
  haircords[300][1] = 685;
  
  haircords[301][0] = 705;
  haircords[301][1] = 685;
}
