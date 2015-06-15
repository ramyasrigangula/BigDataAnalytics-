//
//  SecondViewController.m
//  assingment1
//
//  Created by Gaddala, Shivani (UMKC-Student) on 6/12/15.
//  Copyright (c) 2015 Gaddala, Shivani (UMKC-Student). All rights reserved.
//

#import "SecondViewController.h"
#import "ThirdViewController.h"

@interface SecondViewController ()

@end

@implementation SecondViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}

/*
#pragma mark - Navigation

// In a storyboard-based application, you will often want to do a little preparation before navigation
- (void)prepareForSegue:(UIStoryboardSegue *)segue sender:(id)sender {
    // Get the new view controller using [segue destinationViewController].
    // Pass the selected object to the new view controller.
}
*/
- (IBAction)tappedOnGO:(id)sender {
    ThirdViewController *controller = [self.storyboard instantiateViewControllerWithIdentifier:@"ThirdViewController"];
    [self presentViewController:controller animated:YES completion:NULL];
}

@end
