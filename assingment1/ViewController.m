//
//  ViewController.m
//  assingment1
//
//  Created by Gaddala, Shivani (UMKC-Student) on 6/12/15.
//  Copyright (c) 2015 Gaddala, Shivani (UMKC-Student). All rights reserved.
//

#import "ViewController.h"
#import "SecondViewController.h"
#import "ThirdViewController.h"

@interface ViewController ()
@property (strong, nonatomic) IBOutlet UILabel *messageLabel;

@end

@implementation ViewController

- (void)viewDidLoad {
    [super viewDidLoad];
    // Do any additional setup after loading the view, typically from a nib.
}

- (void)didReceiveMemoryWarning {
    [super didReceiveMemoryWarning];
    // Dispose of any resources that can be recreated.
}
- (IBAction)tappedOnShow:(id)sender {
    _messageLabel.text = @"Hello Everyone";
}

- (IBAction)tappedOnNext:(id)sender {
    SecondViewController *controller = [self.storyboard instantiateViewControllerWithIdentifier:@"SecondViewController"];
    [self presentViewController:controller animated:YES completion:NULL];
    
}

@end
